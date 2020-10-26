package com.censusanalysis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyzerTest {
    private StateCensusAnalyzer stateCensusAnalyzer;

    @Before
    public void init() {
        stateCensusAnalyzer = new StateCensusAnalyzer();
    }

    @Test
    public void givenCSV_WhenRead_ShouldReturnCorrectRecordCount() {
        try {
            String CSV_PATH = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\StateCensusData.csv";
            int result = stateCensusAnalyzer.readCSVData(CSV_PATH);
            Assert.assertEquals(29, result);
        } catch (IOException | StateAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCSVFilePath_WhenIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_CSV_PATH = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\StateCensusData.csv";
            stateCensusAnalyzer.readCSVData(INCORRECT_CSV_PATH);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_PATH,
                    e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAFile_WhenTypeIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_CSV_FILE_TYPE = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\InvalidFileTypeSample.json";
            stateCensusAnalyzer.readCSVData(INCORRECT_CSV_FILE_TYPE);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_TYPE,
                    e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCSVFile_WhenDelimiterIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_CSV_DELIMITER = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\InvalidDelimStateCensusData.csv";
            stateCensusAnalyzer.readCSVData(INCORRECT_CSV_DELIMITER);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(StateAnalyzerException.ExceptionType.INVALID_DELIM
                    , e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCSVFile_WhenHeaderIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_CSV_HEADER = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\InvalidHeaderStateCensusData.csv";
            stateCensusAnalyzer.readCSVData(INCORRECT_CSV_HEADER);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(StateAnalyzerException.ExceptionType.INVALID_HEADER
                    , e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
