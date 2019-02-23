package com.nomad99.garbagecollectionanalysispoc.operation.service.test_case;

public interface TestCase {

    void run();

    void setNumberOfWarmupRounds(int warmupRounds);

    void setNumberOfIterations(int iterations);
}
