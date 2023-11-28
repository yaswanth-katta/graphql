package com.cts.graphql.exception;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler{
    @GraphQlExceptionHandler
    public GraphQLError handleNoRecordFoundException(NoRecordFoundException exception){
        return GraphQLError.newError()
                .message(exception.getMessage())
                .build();
    }

}
