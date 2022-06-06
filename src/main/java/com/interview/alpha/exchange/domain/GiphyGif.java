package com.interview.alpha.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GiphyGif {
    @JsonProperty("embed_url")
    private String embedURL;
}
