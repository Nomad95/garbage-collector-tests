package com.nomad99.garbagecollectionanalysispoc.operation.service.test_case;

import com.nomad99.garbagecollectionanalysispoc.operation.executor.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SingleThreadTestCase implements TestCase {

    private final Operation operation;

    private int warmupRounds;

    private int iterations = 1;

    @Override
    public void run() {
        log.info("Starting benchmark");

        if (warmupRounds > 0) {
            log.info("Warm up rounds");
            for (int i = 1; i <= warmupRounds; i++) {
                log.info("Warm up round: " + i);
                operation.doOperation();
            }

            log.info("Warm up ended");
        }

        for (int i = 1; i <= iterations; i++) {
            log.info("Iteration " + i);
            operation.doOperation();
        }

        log.info("Benchmark finished");
    }

    @Override
    public void setNumberOfWarmupRounds(int warmupRounds) {
        if (warmupRounds < 0) throw new IllegalArgumentException("Argument cant be negative");
        this.warmupRounds = warmupRounds;
    }

    @Override
    public void setNumberOfIterations(int iterations) {
        if (iterations <= 0) throw new IllegalArgumentException("Argument cant be negative or zero");
        this.iterations = iterations;
    }
}
