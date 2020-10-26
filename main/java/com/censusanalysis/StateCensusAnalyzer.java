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

    private void isHeaderCorrect(Reader reader) throws StateAnalyzerException, IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String header;
        if ((header = bufferedReader.readLine()) != null) {
            String[] headerArray = header.split(",");
            boolean flagCorrectHead = headerArray[0].equals("State") &&
                    headerArray[1].equals("Population") &&
                    headerArray[2].equals("AreaInSqKm") &&
                    headerArray[3].equals("DensityPerSqKm");
            if (!flagCorrectHead) {
                throw new StateAnalyzerException("Invalid Headers",
                        StateAnalyzerException.ExceptionType.INVALID_HEADER);
            }
        }
    }

    private void isCSVDelimiterCorrect(Reader reader) throws IOException, StateAnalyzerException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(reader);
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.contains(","))
                throw new StateAnalyzerException("Invalid Delimiter", StateAnalyzerException.ExceptionType.INVALID_DELIM);
        }
    }

    public int readCSVData(String filePath) throws IOException, StateAnalyzerException {
        //Check File Path
        try {
            Files.newBufferedReader(Paths.get(filePath));
        } catch (IOException e) {
            throw new StateAnalyzerException("Invalid Path Name",
                    StateAnalyzerException.ExceptionType.INVALID_FILE_PATH);
        }

        //Check File Type
        if (!isCSVFile(filePath))
            throw new StateAnalyzerException("Invalid File Type", StateAnalyzerException.ExceptionType.INVALID_FILE_TYPE);

        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        reader.mark(1000);

        //Check CSV Delimiter
        isCSVDelimiterCorrect(reader);

        //Check Headers
        reader.reset();
        isHeaderCorrect(reader);

        //Get Records Count
        reader.reset();
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
