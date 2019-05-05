package no.oslomet.data.controller;

import no.oslomet.data.models.TweetUser;
import no.oslomet.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/users", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{twitterId}")
    public ResponseEntity<TweetUser> getUserById(@PathVariable("twitterId") Long twitterId) {
        Optional<TweetUser> optionalUser = userService.getUserById(twitterId);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @ResponseBody
    public List<TweetUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public @ResponseBody
    TweetUser create(@RequestBody TweetUser user) {
        return userService.save(user);
    }

    @DeleteMapping(path = "{tweeterId}")
    public ResponseEntity deleteUserByID(@PathVariable(name = "tweeterId") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.accepted().build();
    }

}
