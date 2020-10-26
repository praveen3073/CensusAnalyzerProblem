package com.censusanalysis;

import com.opencsv.bean.CsvBindByPosition;

public class CSVStates {
    @CsvBindByPosition(position = 0)
    private int srNo;

    @CsvBindByPosition(position = 1)
    private String stateName;

    @CsvBindByPosition(position = 2)
    private String tIN;

    @CsvBindByPosition(position = 3)
    private String stateCode;

    @Override
    public String toString() {
        return "IndiaStateCensus [ SrNo = " + srNo +
                ", State Name = " + stateName +
                ", TIN = " + tIN +
                ", State Code = " + stateCode + " ]";
    }
}
