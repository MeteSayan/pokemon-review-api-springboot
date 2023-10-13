package com.pokemonreview.api.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private long id;
    private String title;
    private String content;
    private int stars;
}
