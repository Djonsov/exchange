package com.interview.alpha.exchange;

import com.interview.alpha.exchange.app.api.exchange.ExchangeService;
import com.interview.alpha.exchange.app.api.giphy.GiphyService;
import com.interview.alpha.exchange.app.api.localdate.LocalDateService;
import com.interview.alpha.exchange.domain.ExchangeRates;
import com.interview.alpha.exchange.domain.GiphyGifResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExchangeServiceTest {
    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private LocalDateService localDateService;
    @Autowired
    private GiphyService giphyService;

    @Test
    public void getExchangeRates(){
        ExchangeRates todayRates = exchangeService.getRates("RUB");
        ExchangeRates yesterdayRates = exchangeService.getRatesByDate( localDateService.getYesterdayDate(), "RUB");
        GiphyGifResponse responseRich = giphyService.getRandomGif("rich");
        GiphyGifResponse responseBroke = giphyService.getRandomGif("broke");
        assertAll(
                () -> assertNotNull(todayRates.getRates().get("RUB")),
                () -> assertNotNull(yesterdayRates.getRates().get("RUB")),
                () -> assertNotNull(responseRich.getData().getEmbedURL()),
                () -> assertNotNull(responseBroke.getData().getEmbedURL())
        );
    }
}
