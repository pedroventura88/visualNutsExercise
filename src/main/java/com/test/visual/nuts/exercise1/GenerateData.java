package com.test.visual.nuts.exercise1;

import com.test.visual.nuts.exercise2.Country;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GenerateData {

    /**
     * For exercise1
     * */
    public List<Integer> getIntegers() {
        return IntStream.range(1, 101).boxed().collect(Collectors.toList());
    }


    /**
     * For exercise2
     * The languages informed are just for the test case
     */
    public List<Country> getCountries() {
        Country us = Country.builder().name("United States").languages(Arrays.asList("en")).build();
        Country po = Country.builder().name("Poland").languages(Arrays.asList("nl", "fr", "de")).build();
        Country fr = Country.builder().name("France").languages(Arrays.asList("nl", "fr", "pt","jp")).build();
        Country br = Country.builder().name("Brazil").languages(Arrays.asList("nl", "fr","de")).build();
        Country de = Country.builder().name("German").languages(Arrays.asList("de")).build();
        Country pt = Country.builder().name("Portugal").languages(Arrays.asList("de", "ar")).build();
        Country es = Country.builder().name("Spain").languages(Arrays.asList("es", "ru")).build();
        Country tu = Country.builder().name("Turkey").languages(Arrays.asList("de", "fr", "pt", "es")).build();
        Country jp = Country.builder().name("Japan").languages(Arrays.asList("ja", "ru", "fr")).build();
        return Arrays.asList(us, po, fr, br, de, pt, es, tu, jp);
    }
}
