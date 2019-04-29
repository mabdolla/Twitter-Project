package no.oslomet.data.rest.user;

import no.oslomet.common.api.User;

import java.io.Serializable;

public class TweetUser implements User, Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String twitterId;

    public TweetUser(String firstName, String lastName, String email, String twitterId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.twitterId = twitterId;
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

    public String getTwitterId() {
        return twitterId;
    }
}
