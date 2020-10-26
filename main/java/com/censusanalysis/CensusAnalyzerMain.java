package com.censusanalysis;

import java.io.IOException;

public class CensusAnalyzerMain {
    public static void main(String[] args) {
        try {
            StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
            stateCensusAnalyzer.readCSVData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
