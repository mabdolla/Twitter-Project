package no.oslomet.data.service;

import no.oslomet.data.models.TweetUser;
import no.oslomet.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<TweetUser> getUserById(Long twitterId) {
        return userRepository.findById(twitterId);
    }

    public List<TweetUser> getAllUsers(){
        return userRepository.findAll();
    }

    public TweetUser save(TweetUser user){
        return  userRepository.saveAndFlush(user);
    }

    public void deleteUserById (Long id){
        userRepository.deleteById(id);
    }

}
