package no.oslomet.clientdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.oslomet.common.api.User;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterUser implements User {

    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String email;
    @JsonProperty
    private List<Tweet> tweets;


    public TwitterUser() {
    }

    public TwitterUser(String firstName, String lastName, String email, List<Tweet> tweets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tweets = tweets;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public Long getTwitterId() {
        return null;
    }
}
