package com.interview.alpha.exchange.app.api.giphy;

import com.interview.alpha.exchange.domain.GiphyGifResponse;

public interface GiphyService {
    GiphyGifResponse getRandomGif(String tag);
}
