package com.censusanalysis;

import com.opencsv.bean.CsvBindByPosition;

public class CSVStateCensus {
    @CsvBindByPosition(position = 0)
    private String state;

    @CsvBindByPosition(position = 1)
    private long pop;

    @CsvBindByPosition(position = 2)
    private int area;

    @CsvBindByPosition(position = 3)
    private int density;

    @Override
    public String toString() {
        return "IndiaStateCensus [ State = " + state +
                ", Population = " + pop +
                ", AreaInSqKm = " + area +
                ", density = " + density + " ]";
    }
}
