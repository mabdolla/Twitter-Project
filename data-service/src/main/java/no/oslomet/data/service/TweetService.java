package no.oslomet.data.service;

import no.oslomet.data.models.Tweet;
import no.oslomet.data.models.TweetUser;
import no.oslomet.data.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TweetService {

    String BASE_URL = "http://localhost:9050/tweets";

    private RestTemplate restTemplate = new RestTemplate();

    private final TweetRepository tweetRepository;
    private final UserService userService;

    @Autowired
    public TweetService(TweetRepository tweetRepository, UserService userService) {
        this.tweetRepository = tweetRepository;
        this.userService = userService;
    }

    public List<Tweet> getAllTweets(){
        return tweetRepository.findAll();
    }

    public List<Tweet> getAllTickets(){
        return  Arrays.stream(
                restTemplate.getForObject(BASE_URL, Tweet[].class)
        ).collect(Collectors.toList());
    }

    public Tweet getTweetById(long id){
        return tweetRepository.findById(id).get();
    }


    public Optional<Tweet> save(Long userId, Tweet tweet){
        Optional<TweetUser> optionalUser = userService.getUserById(userId);
        if (!optionalUser.isPresent()) {
            return Optional.empty();
        }
        TweetUser tweetUser = optionalUser.get();
        tweet.setTweetUser(tweetUser);
        return Optional.of(tweetRepository.save(tweet));
    }


    public List<Tweet> getAllTweetsByUserId(Long userId) {
        return tweetRepository.findAllByTweetUser_TwitterId(userId);
    }
}
