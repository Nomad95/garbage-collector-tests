package com.nomad99.garbagecollectionanalysispoc.operation.controller;

import com.nomad99.garbagecollectionanalysispoc.operation.service.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for executing test operations via endpoints
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/operation")
public class OperationController {

    private final OperationService operationService;

    @PostMapping("/complex-one")
    public ResponseEntity<Void> doSomeComplexOperations() {
        operationService.doComplexOperation();
        return ResponseEntity.ok().build();
    }
}

