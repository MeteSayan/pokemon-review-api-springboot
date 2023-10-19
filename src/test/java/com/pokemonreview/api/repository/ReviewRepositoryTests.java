package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Review;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ReviewRepositoryTests {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewRepositoryTests(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Test
    public void ReviewRepository_Save_ReturnsSavedReview() {
        Review review = Review.builder().title("title").content("content").stars(5).build();

        Review savedReview = reviewRepository.save(review);

        Assertions.assertThat(savedReview).isNotNull();
        Assertions.assertThat(savedReview.getId()).isGreaterThan(0);
    }

    @Test
    public void ReviewRepository_GetAll_ReturnsMoreThanOneReview() {
        Review review = Review.builder().title("title").content("content").stars(5).build();
        Review review2 = Review.builder().title("title").content("content").stars(5).build();

        reviewRepository.save(review);
        reviewRepository.save(review2);

        List<Review> reviewList = reviewRepository.findAll();

        Assertions.assertThat(reviewList).isNotNull();
        Assertions.assertThat(reviewList.size()).isEqualTo(2);
    }

    @Test
    public void ReviewRepository_FindById_ReturnsSavedReview() {
        Review review = Review.builder().title("title").content("content").stars(5).build();

        reviewRepository.save(review);

        Review reviewReturn = reviewRepository.findById(review.getId()).get();

        Assertions.assertThat(reviewReturn).isNotNull();
    }
}
