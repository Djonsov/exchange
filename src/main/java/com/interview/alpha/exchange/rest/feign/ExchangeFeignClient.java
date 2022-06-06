package com.interview.alpha.exchange.rest.feign;

import com.interview.alpha.exchange.domain.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="exchangeFeignClient", url = "${openexchangerates.general.url}")
public interface ExchangeFeignClient {
    @GetMapping("/historical/{date}.json")
    ExchangeRates getExchangeRatesByDate(@RequestParam("app_id")String app_id, @PathVariable("date") String date, @RequestParam("base") String base, @RequestParam("symbols") String symbols);
    @GetMapping(path = "/latest.json", consumes = "application/json")
    ExchangeRates getRates(@RequestParam("app_id")String app_id, @RequestParam("base") String base, @RequestParam("symbols") String symbols);
}
