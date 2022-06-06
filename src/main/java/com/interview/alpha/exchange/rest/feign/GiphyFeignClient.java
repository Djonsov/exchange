package com.interview.alpha.exchange.rest.feign;

import com.interview.alpha.exchange.domain.GiphyGifResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="giphyFeignClient", url = "${giphy.general.url}")
public interface GiphyFeignClient {
    @GetMapping(value = "/random", consumes = "application/json")
    GiphyGifResponse getRandomGif(@RequestParam("api_key") String api_key, @RequestParam("tag") String tag);
}
