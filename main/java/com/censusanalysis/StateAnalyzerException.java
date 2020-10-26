package com.censusanalysis;

public class StateAnalyzerException extends Exception {
    public ExceptionType type;

    public StateAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        INVALID_FILE_PATH,
        INVALID_FILE_TYPE,
        INVALID_DELIM
    }
}
