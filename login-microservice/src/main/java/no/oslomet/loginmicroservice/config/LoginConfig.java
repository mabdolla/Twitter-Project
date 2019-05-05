package no.oslomet.loginmicroservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoginConfig {

    @Bean
    @Qualifier("tweetServiceTemplate")
    public RestTemplate tweetServiceTemplate() {
        return new RestTemplate();
    }
}
