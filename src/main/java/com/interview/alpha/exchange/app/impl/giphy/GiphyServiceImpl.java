package com.interview.alpha.exchange.app.impl.giphy;

import com.interview.alpha.exchange.app.api.giphy.GiphyService;
import com.interview.alpha.exchange.domain.GiphyGifResponse;
import com.interview.alpha.exchange.rest.feign.GiphyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GiphyServiceImpl implements GiphyService {
    @Value("${giphy.api.key}")
    private String api_key;
    @Autowired
    private GiphyFeignClient giphyFeignClient;

    @Override
    public GiphyGifResponse getRandomGif(String tag) {
        return giphyFeignClient.getRandomGif(api_key,tag);
    }
}
