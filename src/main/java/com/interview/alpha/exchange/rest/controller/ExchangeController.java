package com.interview.alpha.exchange.rest.controller;

import com.interview.alpha.exchange.app.api.exchange.ExchangeService;
import com.interview.alpha.exchange.app.api.giphy.GiphyService;
import com.interview.alpha.exchange.app.api.localdate.LocalDateService;
import com.interview.alpha.exchange.domain.ExchangeRates;
import com.interview.alpha.exchange.domain.GiphyGifResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    @Autowired
    private LocalDateService localDateService;
    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private GiphyService giphyService;

    @GetMapping("/exchange{symbol}")
    public ResponseEntity<String> getExchange(@PathVariable("symbol") String symbol) {
        ExchangeRates exchangeRates = exchangeService.getRates(symbol.toUpperCase());
        ExchangeRates yesterdayExchangeRates = exchangeService.getRatesByDate(localDateService.getYesterdayDate(), symbol);
        GiphyGifResponse giphyGif = giphyService.getRandomGif(exchangeRates.getRates().get(symbol) > yesterdayExchangeRates.getRates().get(symbol) ? "rich" : "broke");
        return ResponseEntity.ok().body(giphyGif.getData().getEmbedURL());
    }
}
