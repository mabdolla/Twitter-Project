package no.oslomet.data.controller;

import no.oslomet.data.models.Tweet;
import no.oslomet.data.models.TwitterUser;
import no.oslomet.data.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {

        Tweet tweet = new Tweet("hello", 1, 2, 3);
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(tweet);
        TwitterUser twitterUser = new TwitterUser("nmm", "ee", "ff", tweets);

        this.tweetService = tweetService;
    }

    @GetMapping("/")
    public String getAllTweets(Model model) {
        model.addAttribute("tweets",tweetService.getAllTweets());
        return "list";
    }

    @GetMapping(path = "/user/{userId}")
    public List<Tweet> getAllTweetsByUser(@PathVariable(name = "userId") Long userId) {
        return tweetService.getAllTweetsByUserId(userId);
    }

    @GetMapping(path = "{tweetId}")
    public Tweet getTweetById(@PathVariable(value = "tweetId") Long id) {
        return tweetService.getTweetById(id);
    }

    @PostMapping(path = "/user/{userId}")
    public ResponseEntity<Tweet> saveTweet(@PathVariable(name = "userId") Long userId, @RequestBody Tweet tweet) {
        Optional<Tweet> optionalTweet = tweetService.save(userId, tweet);
        if (!optionalTweet.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalTweet.get());
    }

}