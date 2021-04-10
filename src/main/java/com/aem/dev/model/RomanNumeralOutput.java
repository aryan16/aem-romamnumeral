package com.aem.dev.model;

import lombok.Getter;
import lombok.Setter;

/**
 * response output format
 */
@Getter
@Setter
public class RomanNumeralOutput {

    private String input;
    private String output;


    public RomanNumeralOutput(String input, String output) {
        this.input = input;
        this.output = output;
    }
}
