package services.implementation;

import dao.TweetDao;
import dao.UserDao;
import dao.implementation.TweetDaoImpl;
import dao.implementation.UserDaoImpl;
import model.Tweet;
import model.User;
import services.TweetMenagerServices;

import java.util.List;
import java.util.Set;

public class TweetMenagerServicesImpl implements TweetMenagerServices {

    private TweetDao tweetDao;
    private UserDao userDao;

    public TweetMenagerServicesImpl() {
        this.tweetDao = new TweetDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    @Override
    public void addTweet(String userLogin, String message) {
        User userByLogin = userDao.getUserByLogin(userLogin);
        tweetDao.addTweet(userByLogin, message);
    }

    @Override
    public void update(Long tweetId, String message) {
        tweetDao.updateTweet(tweetId, message);
    }

    @Override
    public void deleteTweet(Long tweetId) {
        tweetDao.deleteTweet(tweetId);
    }

    @Override
    public List<Tweet> getFollowedTweets(String login) {
        List<Tweet> tweets =  tweetDao.getUserTweets(login);
        Set<User> followUser = userDao.getFollows(login);
        followUser.forEach(f -> tweets.addAll(tweetDao.getUserTweets(f.getLogin())));
        return tweets;
    }
}
