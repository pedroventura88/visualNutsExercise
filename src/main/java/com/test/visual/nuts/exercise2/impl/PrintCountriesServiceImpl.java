package com.test.visual.nuts.exercise2.impl;

import com.test.visual.nuts.exercise1.GenerateData;
import com.test.visual.nuts.exercise2.Country;
import com.test.visual.nuts.exercise2.PrintCountriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PrintCountriesServiceImpl implements PrintCountriesService {
    private static final Logger LOG = LoggerFactory.getLogger(PrintCountriesServiceImpl.class);

    private GenerateData generateData;

    public PrintCountriesServiceImpl(GenerateData generateData) {
        this.generateData = generateData;
    }

    /**
     * @return number of countries in the world
     */
    @Override
    public Integer printNumberOfCountriesInTheWorld() {
        Integer numberOfCountries = generateData.getCountries().size();
        LOG.info("The number of countries in the world is: " + numberOfCountries);
        return numberOfCountries;
    }

    /**
     * @return country with the most official languages, where they officially speak German (de).
     */
    @Override
    public List<Map.Entry<String, List<String>>> printCountryWithMostImportantLanguageGerman() {
        Map<String, List<String>> germanCountriesMap = new HashMap<>();
        for (Country country : generateData.getCountries()) {
            for (String language : country.getLanguages()) {
                if ("de".equalsIgnoreCase(language)) {
                    germanCountriesMap.put(country.getName(), country.getLanguages());
                }
            }
        }

        if (germanCountriesMap.size() <= 0) {
            LOG.warn("In the list of {} countries, none of them speaks german", generateData.getCountries().size());
            return new ArrayList<>();
        }

        if (germanCountriesMap.size() > 1) {
            List<Map.Entry<String, List<String>>> countries = checkCountriesWithHighestNumberOfSpokenLanguages(germanCountriesMap);

            LOG.info("Countries with the most official language, where they officially speak German: " +
                    countries);
            return countries;
        }

        List<Map.Entry<String, List<String>>> singleCountry = germanCountriesMap.entrySet().stream().collect(Collectors.toList());
        LOG.info("{} is the country with highest number of spoken languages, that also speaks german", singleCountry);
        return singleCountry;
    }

    /**
     * @return - count of all official languages spoken in the listed countries.
     */
    @Override
    public Integer printCountOfSpokenLanguagesOnListedCountries() {
        Set<String> languages = new HashSet<>();
        generateData.getCountries().stream().forEach(country -> languages.addAll(country.getLanguages()));
        LOG.info("The number of spoken languages on countries are " + languages.size());
        return languages.size();
    }

    /**
     * @return - List of Map<String, List<String>>, containning find the country with the highest number of official languages
     * explanation: This function returns a list, because if there's more than one country with the same size of spoken languages,
     * it will return all the occurrences
     */
    @Override
    public List<Map.Entry<String, List<String>>> printCountriesWithHighestNumberOfSpokenLanguages() {
        Map<String, List<String>> countriesMap = new HashMap<>();
        generateData.getCountries().forEach(country -> countriesMap.put(country.getName(), country.getLanguages()));
        List<Map.Entry<String, List<String>>> countries = checkCountriesWithHighestNumberOfSpokenLanguages(countriesMap);
        LOG.info("Countries with the highest number of official languages: {}", countries);
        return countries;
    }

    /**
     * @return - the most common official language of all countries
     */
    @Override
    public Map<String, Long> printTheMostCommonOfficialLanguageOfAllCountries() {
        List<String> languages = new ArrayList<>();
        for (Country country : generateData.getCountries()) {
            languages.addAll(country.getLanguages());
        }

        Map<String, Long> result = languages.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long highestNumber = result.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
        Map<String, Long> languagesSpoken = result.entrySet()
                .stream()
                .filter(languageCount -> highestNumber.equals(languageCount.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        languagesSpoken
                .entrySet()
                .forEach(language -> LOG.info("The most official languages are: {}, appeared {} times ", language.getKey(), language.getValue()));
        return languagesSpoken;
    }

    private List<Map.Entry<String, List<String>>> checkCountriesWithHighestNumberOfSpokenLanguages(Map<String, List<String>> countriesMap) {
        Optional<Integer> highestValueOfSpokenLanguages = countriesMap.entrySet()
                .stream()
                .map(country -> country.getValue().size()).collect(Collectors.toList())
                .stream()
                .findFirst();

        List<Map.Entry<String, List<String>>> countries = countriesMap.entrySet()
                .stream()
                .filter(country -> highestValueOfSpokenLanguages.get() == country.getValue().size())
                .collect(Collectors.toList());

        return countries;
    }


}
