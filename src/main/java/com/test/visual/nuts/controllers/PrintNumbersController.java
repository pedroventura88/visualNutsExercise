package com.test.visual.nuts.controllers;

import com.test.visual.nuts.exercise1.PrintNumbersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nuts/v1")
public class PrintNumbersController {
    private static final Logger LOG = LoggerFactory.getLogger(PrintNumbersController.class);

    private PrintNumbersService service;

    public PrintNumbersController(PrintNumbersService service) {
        this.service = service;
    }

    @GetMapping("/numbers")
    public ResponseEntity<List<?>> getNumbersProcessed() {
        try {
            return ResponseEntity.ok(service.processNumbers());
        } catch (Exception e) {
            LOG.error("Some unexpected exception happened on getting numbers Processed", e);
            throw new RuntimeException(e);
        }
    }
}
