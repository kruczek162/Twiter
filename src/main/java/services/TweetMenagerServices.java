package services;

import model.Tweet;
import model.User;

import java.util.List;
import java.util.Set;

public interface TweetMenagerServices {

    void addTweet (String userLogin, String message);
    void update (Long tweetId, String message);
    void deleteTweet(Long tweetid);
    public List<Tweet> getFollowedTweets(String login);


}
