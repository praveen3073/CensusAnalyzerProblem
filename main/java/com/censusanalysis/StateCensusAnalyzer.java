package com.censusanalysis;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class StateCensusAnalyzer {
    private static int count = 0;

    private boolean isCSVFile(String filePath) {
        return Pattern.matches(".*\\.csv", filePath);
    }

    public int readCSVData(String filePath) throws IOException, StateAnalyzerException {
        try {
            Files.newBufferedReader(Paths.get(filePath));
        } catch (IOException e) {
            throw new StateAnalyzerException("Invalid Path Name",
                    StateAnalyzerException.ExceptionType.INVALID_FILE_PATH);
        }
        if (isCSVFile(filePath) == false)
            throw new StateAnalyzerException("Invalid File Type", StateAnalyzerException.ExceptionType.INVALID_FILE_TYPE);
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.contains(","))
                throw new StateAnalyzerException("Invalid Delimiter", StateAnalyzerException.ExceptionType.INVALID_DELIM);
        }
        CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                .withIgnoreLeadingWhiteSpace(true)
                .withSkipLines(1)
                .withType(CSVStateCensus.class).build();

        for (CSVStateCensus csvStateCensus : csvToBean) {
            count++;
            System.out.println(csvStateCensus);
        }
        return count;
    }
}
