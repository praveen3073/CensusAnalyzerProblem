package com.censusanalysis;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyzer {
    private final String CSV_PATH = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\StateCensusData.csv";

    public void readCSVData() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .withType(CSVStateCensus.class).build();
            Iterator<CSVStateCensus> csvIterator = csvToBean.iterator();
            while (csvIterator.hasNext()) {
                CSVStateCensus csvData = csvIterator.next();
                System.out.println(csvData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
