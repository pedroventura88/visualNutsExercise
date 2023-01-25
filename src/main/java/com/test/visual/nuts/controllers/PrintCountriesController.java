package com.test.visual.nuts.controllers;


import com.test.visual.nuts.exercise2.PrintCountriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nuts/v1")
public class PrintCountriesController {

    private static final Logger LOG = LoggerFactory.getLogger(PrintNumbersController.class);

    private PrintCountriesService service;

    public PrintCountriesController(PrintCountriesService service) {
        this.service = service;
    }

    @GetMapping("/numberOfCountriesInTheWorld")
    public ResponseEntity<Integer> numberOfCountriesInTheWorld() {
        try {
            return ResponseEntity.ok(service.printNumberOfCountriesInTheWorld());
        } catch (Exception e) {
            LOG.error("Some unexpected exception happened on printNumberOfCountriesInTheWorld ",e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/countryWithMostImportantLanguageGerman")
    public ResponseEntity<List<Map.Entry<String, List<String>>>> countryWithMostImportantLanguageGerman() {
        try {
            return ResponseEntity.ok(service.printCountryWithMostImportantLanguageGerman());
        } catch (Exception e) {
            LOG.error("Some unexpected exception happened on printCountryWithMostImportantLanguageGerman ",e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/countOfSpokenLanguagesOnListedCountries")
    public ResponseEntity<Integer> countOfSpokenLanguagesOnListedCountries() {
        try {
            return ResponseEntity.ok(service.printCountOfSpokenLanguagesOnListedCountries());
        } catch (Exception e) {
            LOG.error("Some unexpected exception happened on printCountOfSpokenLanguagesOnListedCountries ",e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/countriesWithHighestNumberOfSpokenLanguages")
    public ResponseEntity<List<Map.Entry<String, List<String>>>> countriesWithHighestNumberOfSpokenLanguages() {
        try {
            return ResponseEntity.ok(service.printCountriesWithHighestNumberOfSpokenLanguages());
        } catch (Exception e) {
            LOG.error("Some unexpected exception happened on printCountriesWithHighestNumberOfSpokenLanguages ",e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/mostCommonOfficialLanguageOfAllCountries")
    public ResponseEntity<Map<String, Long>> mostCommonOfficialLanguageOfAllCountries() {
        try {
            return ResponseEntity.ok(service.printTheMostCommonOfficialLanguageOfAllCountries());
        } catch (Exception e) {
            LOG.error("Some unexpected exception happened on printTheMostCommonOfficialLanguageOfAllCountries ",e);
            throw new RuntimeException(e);
        }
    }
}
