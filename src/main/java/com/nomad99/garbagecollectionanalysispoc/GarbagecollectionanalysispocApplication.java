package com.nomad99.garbagecollectionanalysispoc;

import com.nomad99.garbagecollectionanalysispoc.operation.executor.AccumulatorOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class GarbagecollectionanalysispocApplication {

    public static void main(String[] args) {
        //SpringApplication.run(GarbagecollectionanalysispocApplication.class, args);
        ExecutorService es = Executors.newCachedThreadPool();
        AccumulatorOperation accumulatorOperation = new AccumulatorOperation(5000, 100000);
        for(int i=0; i < 2; i++)
            es.execute(accumulatorOperation::doOperation);
        es.shutdown();
    }
}
