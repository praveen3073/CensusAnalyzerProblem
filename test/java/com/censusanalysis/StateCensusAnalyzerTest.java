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
            int result = stateCensusAnalyzer.readCSVData();
            Assert.assertEquals(29, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
