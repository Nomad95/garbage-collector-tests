package com.nomad99.garbagecollectionanalysispoc.operation.model;

public class Accumulator {

    private Long accumulatedAmount;

    public Accumulator() {
        this.accumulatedAmount = 0L;
    }

    public void addValue() {
        //intentional boxing and unboxing
        long tempAmount = accumulatedAmount;
        tempAmount++;
        accumulatedAmount = tempAmount;
    }
}
