package no.oslomet.data.rest.service;

import no.oslomet.data.repository.UserRepository;
import no.oslomet.data.rest.user.TweetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/twitter")
public class TweetService {
    String BASE_URL = "http://localhost:8081";
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public TweetService(UserRepository repository) {
        this.repository = repository;
    }

    private UserRepository repository;

    @GetMapping(path = "/user/{twitterId}")
    @ResponseBody
    public TweetUser getUser(@PathVariable("twitterId") String twitterId) {
        return repository.getUser(twitterId);
    }

//    @GetMapping("/user/twitterId")
//    @ResponseBody
//    public TweetUser getUserById(String twitterId) {
//        TweetUser user = restTemplate.getForObject("http://localhost:8081/user/{twitterId}", TweetUser.class, twitterId);
//        return user;
//    }




}
