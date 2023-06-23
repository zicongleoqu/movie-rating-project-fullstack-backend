package dev.leo.movies.controller;

import dev.leo.movies.model.Review;
import dev.leo.movies.service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId"), payload.get("score")), HttpStatus.CREATED);
    }

    @DeleteMapping("/{reviewId}/{imdbId}")
    public void deleteReview(@PathVariable(value = "reviewId") ObjectId id,
                             @PathVariable(value = "imdbId") String imdbId) {
        Review review = verifyReview(id);
        service.deleteReview(review, imdbId);
    }

    // Helper method to check if review exist
    private Review verifyReview(ObjectId id) throws NoSuchElementException {
        return service.verifyReview(id).orElseThrow(() ->
                new NoSuchElementException("Review doesn't exist for id: " + id));
    }
}
