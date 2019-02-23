package com.nomad99.garbagecollectionanalysispoc.operation.executor;

import com.nomad99.garbagecollectionanalysispoc.operation.model.Accumulator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class AccumulatorOperation implements Operation {

    private int numberOfAccumulators;

    private int numberOfAddedValues;

    @Override
    public void doOperation() {
        log.info("Starting the AccumulatorOperation");

        StopWatch sw = new StopWatch();
        sw.start();

        List<Accumulator> accumulators = new ArrayList<>(1);
        addAccumulators(accumulators);
        iterateThroughAccumulatorsAndDoOperations(accumulators);

        sw.stop();
        double totalTimeSeconds = sw.getTotalTimeSeconds();
        log.info("AccumulatorOperation has ended");
        log.info("Total time estimated: {}", totalTimeSeconds);
        log.info("Throughput: {} op/s", (double) getOperationCount() / totalTimeSeconds);
    }

    private void addAccumulators(List<Accumulator> accumulators) {
        for (int i = 0; i < numberOfAccumulators; i++) {//5000
            accumulators.add(new Accumulator());
        }
    }

    private void iterateThroughAccumulatorsAndDoOperations(List<Accumulator> accumulators) {
        accumulators.forEach(accumulator -> {
            for (int i = 0; i < numberOfAddedValues; i++) {//100000
                accumulator.addValue();
            }
        });
    }

    @Override
    public long getOperationCount() {
        return numberOfAccumulators * numberOfAddedValues;
    }
}
