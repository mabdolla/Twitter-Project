package no.oslomet.loginmicroservice.service;


import no.oslomet.loginmicroservice.model.LoginUser;
import no.oslomet.loginmicroservice.model.TweetUser;
import no.oslomet.loginmicroservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    private final UserRepository userRepository;
    private final RestTemplate template;


    @Value("${tweetservice.url}")
    private String tweetServiceUrl;

    @Autowired
    public LoginService(UserRepository userRepository,
                        @Qualifier("tweetServiceTemplate") RestTemplate template) {
        this.userRepository = userRepository;
        this.template = template;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Test email: " + email);
        Optional<LoginUser> user = userRepository.findUserByEmail(email);
        if (!user.isPresent()) throw new UsernameNotFoundException("Not found user with email: " + email);
        return getUserDetails(user.get());
    }

    private UserDetails getUserDetails(LoginUser user) {
        System.out.println("Test: inside getUserDetails");
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles()).build();
    }

    public long save(LoginUser user) {

        LoginUser savedUser = userRepository.save(user);
        TweetUser tweetUser = new TweetUser(user.getFirstName(), user.getLastName(), user.getEmail());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TweetUser> userHttpEntity = new HttpEntity<>(tweetUser, headers);
        ResponseEntity<String> responseEntity = template.postForEntity(tweetServiceUrl.concat("/users"), userHttpEntity, String.class);

        if (responseEntity.getStatusCode().isError()) {
            log.error("Unable to create tweet user, error code: {}", responseEntity.getStatusCodeValue());
        }
        //todo: shall i not call the data service to create a tweet user?
        if (savedUser != null) {
            return savedUser.getId();
        }
        return -1;
    }

}
