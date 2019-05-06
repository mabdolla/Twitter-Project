package no.oslomet.clientdataservice.service;

import no.oslomet.clientdataservice.model.TwitterUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterUserService {

    @Value("${twitteruserservice.url}")
    public String twitterUserServiceUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public List<TwitterUser> getAllTwitterUsers(){
        return  Arrays.stream(
                restTemplate.getForObject(twitterUserServiceUrl, TwitterUser[].class)
        ).collect(Collectors.toList());
    }

    public TwitterUser getTwitterUserById(long id){
        TwitterUser twitterUser = restTemplate.getForObject(twitterUserServiceUrl +"/"+id, TwitterUser.class);
        return twitterUser;
    }

    public TwitterUser saveTwitterUser(TwitterUser newTwitterUser){
        return restTemplate.postForObject(twitterUserServiceUrl, newTwitterUser, TwitterUser.class);
    }

    public void updateTwitterUser(long id, TwitterUser updatedTwitterUser){
        restTemplate.put(twitterUserServiceUrl +"/"+id, updatedTwitterUser);
    }

    public void deleteTwitterUserById(long id){
        restTemplate.delete(twitterUserServiceUrl +"/"+id);
    }

}
