package com.censusanalysis;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StateCensusAnalyzer {
    private static int count = 0;

    public int readCSVData(String filePath) throws IOException, StateAnalyzerException {
        try {
            Files.newBufferedReader(Paths.get(filePath));
        } catch (IOException e) {
            throw new StateAnalyzerException("Invalid Path Name",
                    StateAnalyzerException.ExceptionType.INVALID_FILE_PATH);
        }
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
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
