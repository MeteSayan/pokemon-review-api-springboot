package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.ReviewDto;

public interface ReviewService {
    ReviewDto createReview(long pokemonId, ReviewDto reviewDto);
}
