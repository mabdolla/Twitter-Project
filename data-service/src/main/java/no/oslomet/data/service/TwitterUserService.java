package no.oslomet.data.service;

import no.oslomet.data.models.TwitterUser;
import no.oslomet.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TwitterUserService {

    private UserRepository userRepository;

    @Autowired
    public TwitterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<TwitterUser> getUserById(Long twitterId) {
        return userRepository.findById(twitterId);
    }

    public List<TwitterUser> getAllUsers() {
        return userRepository.findAll();
    }

    public TwitterUser save(TwitterUser user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
