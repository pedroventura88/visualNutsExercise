package com.test.visual.nuts.exercise1.impl;

import com.test.visual.nuts.exercise1.GenerateData;
import com.test.visual.nuts.exercise1.PrintNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrintNumbersServiceImpl implements PrintNumbersService {

    private GenerateData generateData;

    public PrintNumbersServiceImpl(GenerateData generateData) {
        this.generateData = generateData;
    }

    @Override
    public List<?> processNumbers() {
        List<Object> values = new ArrayList<>();
        Object value;
        for (int number : generateData.getIntegers()) {
            if (number % 3 == 0 && number % 5 == 0) {
                value = "Visual Nuts";
                values.add(value);
                System.out.println(value);
                continue;
            }

            if (!(number % 3 == 0) && !(number % 5 == 0)) {
                System.out.println("" + number);
                values.add(number);
                continue;
            }

            if (number % 3 == 0) {
                value = "Visual";
                values.add(value);
                System.out.println(value);
                continue;
            }

            if (number % 5 == 0) {
                value = "Nuts";
                values.add(value);
                System.out.println(value);
                continue;
            }
        }
        return values;
    }
}
