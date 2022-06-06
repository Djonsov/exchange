package com.interview.alpha.exchange.domain;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeRates {
    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String, Double> rates;
}
