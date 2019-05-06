package no.oslomet.data.service;

import no.oslomet.data.models.Tweet;
import no.oslomet.data.models.TwitterUser;
import no.oslomet.data.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;
    private final TwitterUserService twitterUserService;

    @Autowired
    public TweetService(TweetRepository tweetRepository, TwitterUserService twitterUserService) {
        this.tweetRepository = tweetRepository;
        this.twitterUserService = twitterUserService;
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    public Tweet getTweetById(long id) {
        return tweetRepository.findById(id).get();
    }

    public Optional<Tweet> save(Long userId, Tweet tweet) {
        Optional<TwitterUser> optionalUser = twitterUserService.getUserById(userId);
        if (!optionalUser.isPresent()) {
            return Optional.empty();
        }
        TwitterUser twitterUser = optionalUser.get();
        tweet.setTwitterUser(twitterUser);
        return Optional.of(tweetRepository.save(tweet));
    }

    public List<Tweet> getAllTweetsByUserId(Long userId) {
        return tweetRepository.findAllByTweetUser_TwitterId(userId);
    }
}
