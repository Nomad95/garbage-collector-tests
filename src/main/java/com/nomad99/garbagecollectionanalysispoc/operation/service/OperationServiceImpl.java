package com.nomad99.garbagecollectionanalysispoc.operation.service;

import com.nomad99.garbagecollectionanalysispoc.operation.executor.AccumulatorOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OperationServiceImpl implements OperationService {

    @Override
    public void doComplexOperation() {
        new AccumulatorOperation(5000, 100000).doOperation();
    }
}
