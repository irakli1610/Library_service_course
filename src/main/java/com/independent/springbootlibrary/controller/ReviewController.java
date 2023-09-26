package com.independent.springbootlibrary.controller;

import com.independent.springbootlibrary.requestmodels.ReviewRequest;
import com.independent.springbootlibrary.service.ReviewService;
import com.independent.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value = "Authorization")String token,
                                    @RequestParam Long bookId)throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if(userEmail == null) {
            throw new Exception("user email null");
        }
        return reviewService.userReviewListed(userEmail,bookId);
    }
    @PostMapping("/secure")
    public  void postReview(@RequestHeader(value = "Authorization")String token,
                            @RequestBody ReviewRequest reviewRequest)throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if(userEmail == null){
            throw  new Exception("user email null");
        }
        reviewService.postReview(userEmail,reviewRequest);
    }

}
