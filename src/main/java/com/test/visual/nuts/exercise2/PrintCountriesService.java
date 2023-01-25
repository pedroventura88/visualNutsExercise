package com.test.visual.nuts.exercise2;

import java.util.List;
import java.util.Map;

public interface PrintCountriesService {
    Integer printNumberOfCountriesInTheWorld();
    List<Map.Entry<String, List<String>>> printCountryWithMostImportantLanguageGerman();
    Integer printCountOfSpokenLanguagesOnListedCountries();
    List<Map.Entry<String, List<String>>> printCountriesWithHighestNumberOfSpokenLanguages();
    Map<String, Long> printTheMostCommonOfficialLanguageOfAllCountries();

}
