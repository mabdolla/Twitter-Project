package no.oslomet.data.models;

import javax.persistence.Entity;

@Entity
public class Tweet {

    private int id;
    private String text;
    private int likes;
    private int dislikes;
    private int retweets;
    

}
