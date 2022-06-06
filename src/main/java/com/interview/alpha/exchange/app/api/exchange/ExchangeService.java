package com.interview.alpha.exchange.app.api.exchange;

import com.interview.alpha.exchange.domain.ExchangeRates;

import java.time.LocalDate;


public interface ExchangeService {
    ExchangeRates getRatesByDate(LocalDate date, String symbol);
    ExchangeRates getRates(String symbol);
}
