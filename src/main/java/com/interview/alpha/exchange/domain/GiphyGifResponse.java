package com.interview.alpha.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GiphyGifResponse {
    private GiphyGif data;
}
