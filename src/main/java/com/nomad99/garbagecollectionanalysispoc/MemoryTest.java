package com.nomad99.garbagecollectionanalysispoc;

import com.nomad99.garbagecollectionanalysispoc.operation.executor.AccumulatorOperation;
import com.nomad99.garbagecollectionanalysispoc.operation.service.test_case.SingleThreadTestCase;
import com.nomad99.garbagecollectionanalysispoc.operation.service.test_case.TestCase;

public class MemoryTest {

    public static void main(String[] args) {
        TestCase testCase = new SingleThreadTestCase(new AccumulatorOperation(5000, 100000));
        testCase.run();
    }

}
