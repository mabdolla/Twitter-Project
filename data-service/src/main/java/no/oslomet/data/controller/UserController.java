package no.oslomet.data.controller;

import no.oslomet.data.models.TwitterUser;
import no.oslomet.data.service.TwitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/users", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private TwitterUserService twitterUserService;

    @Autowired
    public UserController(TwitterUserService twitterUserService) {
        this.twitterUserService = twitterUserService;
    }

    @GetMapping(path = "{twitterId}")
    public ResponseEntity<TwitterUser> getUserById(@PathVariable("twitterId") Long twitterId) {
        Optional<TwitterUser> optionalUser = twitterUserService.getUserById(twitterId);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @ResponseBody
    public List<TwitterUser> getAllUsers() {
        return twitterUserService.getAllUsers();
    }

    @PostMapping
    public @ResponseBody
    TwitterUser create(@RequestBody TwitterUser user) {
        return twitterUserService.save(user);
    }

    @DeleteMapping(path = "{tweeterId}")
    public ResponseEntity deleteUserByID(@PathVariable(name = "tweeterId") Long id) {
        twitterUserService.deleteUserById(id);
        return ResponseEntity.accepted().build();
    }

}
