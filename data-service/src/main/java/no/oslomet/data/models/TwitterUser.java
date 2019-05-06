package no.oslomet.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.oslomet.common.api.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class TwitterUser implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long twitterId;
    private String email;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "tweetUser", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tweet> tweets;

    public TwitterUser(String email, String firstName, String lastName, List<Tweet> tweets) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tweets = tweets;
    }

    public TwitterUser(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TwitterUser() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(Long twitterId) {
        this.twitterId = twitterId;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @Override
    public String toString() {
        return "TwitterUser{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", twitterId=" + twitterId +
                ", tweets=" + tweets +
                '}';
    }
}
