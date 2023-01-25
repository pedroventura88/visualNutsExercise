package com.test.visual.nuts.exercise2;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Country {
    private String name;
    private List<String> languages;
}
