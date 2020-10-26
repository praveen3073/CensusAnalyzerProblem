package com.censusanalysis;

import java.io.IOException;

public class CensusAnalyzerMain {
    private static final String CSV_PATH = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\StateCensusData.csv";

    public static void main(String[] args) {
        try {
            StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
            stateCensusAnalyzer.readCSVData(CSV_PATH);
        } catch (IOException | StateAnalyzerException e) {
            e.printStackTrace();
        }
    }
}
