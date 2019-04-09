package no.oslomet.data.rest.service;

import no.oslomet.data.repository.UserRepository;
import no.oslomet.data.rest.user.TweetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tweet")
public class TweetService {


    @Autowired
    public TweetService(UserRepository repository) {
        this.repository = repository;
    }

    private UserRepository repository;

    @GetMapping(path = "/user/{tweeterId}")
    @ResponseBody
    public TweetUser getUser(@PathVariable("tweeterId") String tweeterId) {
        return repository.getUser(tweeterId);
    }


}
