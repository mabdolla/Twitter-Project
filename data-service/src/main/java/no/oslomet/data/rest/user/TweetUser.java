package no.oslomet.data.rest.user;

import no.oslomet.common.api.User;

public class TweetUser implements User {

    private String firstName;
    private String lastName;
    private String email;
    private String tweeterId;

    public TweetUser(String firstName, String lastName, String email, String tweeterId) {
        this.firstName = firstName;
        this.lastName = lastName;
        email = email;
        this.tweeterId = tweeterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTweeterId() {
        return tweeterId;
    }
}
