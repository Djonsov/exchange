package com.interview.alpha.exchange.app.impl.exchange;

import com.interview.alpha.exchange.app.api.exchange.ExchangeService;
import com.interview.alpha.exchange.domain.ExchangeRates;
import com.interview.alpha.exchange.rest.feign.ExchangeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Value("${openexchangerates.app.id}")
    private String app_id;
    @Value("${openexchangerates.base}")
    private String base;
    @Autowired
    private ExchangeFeignClient exchangeFeignClient;

    @Override
    public ExchangeRates getRatesByDate(LocalDate date, String symbol){
        return exchangeFeignClient.getExchangeRatesByDate(app_id, date.toString(), base, symbol);
    }
    @Override
    public ExchangeRates getRates(String symbols) {
        return exchangeFeignClient.getRates(app_id, base, symbols);
    }
}
