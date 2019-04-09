package no.oslomet.data.repository;

import no.oslomet.data.models.UserDatabaseImpl;
import no.oslomet.data.rest.user.TweetUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public TweetUser getUser(final String tweeterId) {
        //UserDatabaseImpl user  = databaseConnection.query("Select ");
        return new TweetUser("Me", "You", "me@somewhere.no", tweeterId);
    }
}
