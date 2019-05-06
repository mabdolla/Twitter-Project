package no.oslomet.clientdataservice.controller;

import no.oslomet.clientdataservice.model.Tweet;
import no.oslomet.clientdataservice.model.TwitterUser;
import no.oslomet.clientdataservice.service.TweetService;
import no.oslomet.clientdataservice.service.TwitterUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class TwitterUserController {
    TwitterUserService twitterUserService;

    @GetMapping("/")
    public String getAllTwitterUsers(Model model){
        Tweet tweet = new Tweet("hello",1,2,3);
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(tweet);
        TwitterUser twitterUser = new TwitterUser("ee","ee", "ee",tweets);

        model.addAttribute("tweets",twitterUserService.getAllTwitterUsers());
        return "twitterUserList";
    }

    @GetMapping(path = "{id}")
    public String getTwitterUserById(@PathVariable(value = "id") Long id) {
        twitterUserService.getTwitterUserById(id);
        return "twitterUserList";
    }

    @PostMapping("/saveTwitterUser")
    public String saveTwitterUser(TwitterUser twitterUser, Model model){
        twitterUserService.saveTwitterUser(twitterUser);
        model.addAttribute("tweets", twitterUserService.getAllTwitterUsers());
        return "redirect:/twitterUserList";
    }

    @GetMapping("/edit/{id}")
    public String editTwitterUser(@PathVariable("id") long id, TwitterUser twitterUser){
        twitterUserService.updateTwitterUser(id, twitterUser);
        return "twitterUserForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteTwitterUser(@PathVariable("id") long id, Model model){
        twitterUserService.deleteTwitterUserById(id);
        model.addAttribute("twitterUsers", twitterUserService.getAllTwitterUsers());
        return "redirect:/twitterUserList";
    }

}
