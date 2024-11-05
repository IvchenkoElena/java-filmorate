package ru.yandex.practicum.filmorate.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Review;
import ru.yandex.practicum.filmorate.service.ReviewService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public Review addNew(@RequestBody Review newReview) {
        log.info("Поступил запрос на добавление нового отзыва: {}", newReview.toString());
        return reviewService.addNew(newReview);
    }

    @PutMapping
    public Review update(@RequestBody Review modifiedReview) {
        return reviewService.update(modifiedReview);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        reviewService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Integer id) {
        return reviewService.getById(id);
    }

    @GetMapping
    public List<Review> getByParams(@RequestParam(required = false) Integer filmId,
                                    @RequestParam(defaultValue = "10") Integer count) {
        return reviewService.getByParams(filmId, count);
    }

    @PutMapping("{reviewId}/like/{userId}")
    public void addLike(@PathVariable Integer reviewId, @PathVariable Integer userId) {
        reviewService.addLike(reviewId, userId);
    }

    @PutMapping("{reviewId}/dislike/{userId}")
    public void addDislike(@PathVariable Integer reviewId, @PathVariable Integer userId) {
        reviewService.addDislike(reviewId, userId);
    }

    @DeleteMapping("{reviewId}/like/{userId}")
    public void deleteLike(@PathVariable Integer reviewId, @PathVariable Integer userId) {
        reviewService.deleteLike(reviewId, userId);
    }

    @DeleteMapping("{reviewId}/dislike/{userId}")
    public void deleteDislike(@PathVariable Integer reviewId, @PathVariable Integer userId) {
        reviewService.deleteDislike(reviewId, userId);
    }
}
