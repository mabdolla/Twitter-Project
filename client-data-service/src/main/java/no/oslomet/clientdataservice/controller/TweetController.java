package no.oslomet.clientdataservice.controller;

import no.oslomet.clientdataservice.model.Tweet;
import no.oslomet.clientdataservice.model.TwitterUser;
import no.oslomet.clientdataservice.service.TweetService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class TweetController {

    TweetService tweetService;

    @GetMapping("/")
    public String getAllTweets(Model model){
        Tweet tweet = new Tweet("hello",1,2,3);
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(tweet);
        TwitterUser twitterUser = new TwitterUser("ee","ee", "ee",tweets);

        model.addAttribute("tweets",tweetService.getAllTweets());
        return "tweetList";
    }

    @GetMapping(path = "{tweetId}")
    public String getTweetById(@PathVariable(value = "tweetId") Long id) {
        tweetService.getTweetById(id);
        return "tweetList";
    }

    @PostMapping("/saveTweet")
    public String saveTweet(Tweet tweet, Model model){
        tweetService.saveTweet(tweet);
        model.addAttribute("tweets", tweetService.getAllTweets());
        return "redirect:/tweetList";
    }

    @GetMapping("/edit/{id}")
    public String editTweet(@PathVariable("id") long id, Tweet tweet){
        tweetService.updateTweet(id, tweet);
        return "tweetForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteTweet(@PathVariable("id") long id, Model model){
        tweetService.deleteTweetById(id);
        model.addAttribute("tweets", tweetService.getAllTweets());
        return "redirect:/tweetList";
    }

}
