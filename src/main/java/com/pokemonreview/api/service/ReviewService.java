package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(long pokemonId, ReviewDto reviewDto);

    List<ReviewDto> getReviewsByPokemonId(long id);

    ReviewDto getReviewById(long reviewId, long pokemenId);
}
