package com.cts.graphql.model;

import java.util.concurrent.atomic.AtomicInteger;

public class GenerateId {
    private static final String PREFIX="18B91A120";
    static AtomicInteger atomicInteger=new AtomicInteger(1);

    public static String generateStudentId(){
        return PREFIX+String.format("%d",atomicInteger.getAndIncrement());
    }
}
