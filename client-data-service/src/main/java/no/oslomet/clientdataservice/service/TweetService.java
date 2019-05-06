package no.oslomet.clientdataservice.service;

import no.oslomet.clientdataservice.model.Tweet;
import no.oslomet.clientdataservice.model.TwitterUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {

    @Value("${tweetservice.url}")
    public String tweetServiceUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Tweet> getAllTweets(){
        return  Arrays.stream(
                restTemplate.getForObject(tweetServiceUrl, Tweet[].class)
        ).collect(Collectors.toList());
    }

    public Tweet getTweetById(long id){
        Tweet tweet = restTemplate.getForObject(tweetServiceUrl +"/"+id, Tweet.class);
        return tweet;
    }

    public Tweet getTweetByUserId(long userid){
        Tweet tweet = restTemplate.getForObject(tweetServiceUrl +"/"+userid, Tweet.class);
        return tweet;
    }

    public Tweet saveTweet(Tweet newTweet){
        return restTemplate.postForObject(tweetServiceUrl, newTweet, Tweet.class);
    }

    public void updateTweet(long id, Tweet updatedTweet){
        restTemplate.put(tweetServiceUrl +"/"+id, updatedTweet);
    }

    public void deleteTweetById(long id){
        restTemplate.delete(tweetServiceUrl +"/"+id);
    }



}
