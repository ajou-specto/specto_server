package spectacle.specto.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import spectacle.specto.dto.reviewDto.req.ReviewDto;
import spectacle.specto.service.ReviewService;

import java.time.LocalDate;

@RequestMapping("/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    @PostMapping("")
    public ResponseEntity<?> addReview (@RequestBody @Valid ReviewDto reviewDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = (String)authentication.getCredentials(); //email

        reviewService.postReview(reviewDto, userId);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}