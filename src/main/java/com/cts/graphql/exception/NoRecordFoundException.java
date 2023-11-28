package com.cts.graphql.exception;

import lombok.NoArgsConstructor;

public class NoRecordFoundException extends Exception{
    public NoRecordFoundException(String message){
        super(message);
    }

}
