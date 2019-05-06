package no.oslomet.clientdataservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

public class Tweet {

    @JsonProperty
    private long id;
    @JsonProperty
    private String text;
    @JsonProperty
    private int likes;
    @JsonProperty
    private int dislikes;
    @JsonProperty
    private int retweets;
    @JsonProperty
    private TwitterUser twitterUser;

    public Tweet(String text, int likes, int dislikes, int retweets, TwitterUser twitterUser) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
        this.retweets = retweets;
        this.twitterUser = twitterUser;
    }

    public Tweet() {

    }

    public Tweet(String text, int likes, int dislikes, int retweets) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
        this.retweets = retweets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public TwitterUser getTwitterUser() {
        return twitterUser;
    }

    public void setTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", retweets=" + retweets +
                '}';
    }
}
