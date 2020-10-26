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

    @Test
    public void givenStateCodesCSV_WhenRead_ShouldReturnCorrectRecordCount() {
        String STATECODE_CSV_PATH = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\StateCode.csv";
        int result = 0;
        try {
            result = stateCensusAnalyzer.readStateCodeCSVData(STATECODE_CSV_PATH);
        } catch (StateAnalyzerException | IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(37, result);
    }

    @Test
    public void givenStateCodesCSVFilePath_WhenIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_STATECODE_CSV_PATH = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\StateCode.csv";
            stateCensusAnalyzer.readStateCodeCSVData(INCORRECT_STATECODE_CSV_PATH);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_PATH,
                    e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAFileForStateCodeCSV_WhenTypeIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_STATECODE_CSV_FILE_TYPE = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\InvalidFileTypeSample.json";
            stateCensusAnalyzer.readStateCodeCSVData(INCORRECT_STATECODE_CSV_FILE_TYPE);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_TYPE,
                    e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCodeCSVFile_WhenDelimiterIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_STATECODE_CSV_DELIMITER = "C:\\Users\\Praveen Satya\\IdeaProjects\\CensusAnalysisProblem\\src\\InvalidDelimStateCensusData.csv";
            stateCensusAnalyzer.readStateCodeCSVData(INCORRECT_STATECODE_CSV_DELIMITER);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assert.assertEquals(StateAnalyzerException.ExceptionType.INVALID_DELIM
                    , e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
