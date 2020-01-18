package dao.implementation;

import dao.AbstractDao;
import dao.TweetDao;
import model.Tweet;
import model.User;

import javax.persistence.TypedQuery;
import java.util.List;

public class TweetDaoImpl extends AbstractDao implements TweetDao {


    @Override
    public void addTweet (User user, String message){
        Tweet tweet = new Tweet();
        tweet.setAuthor(user);
        tweet.setMessage(message);

        hibernateConfig.save(tweet);
    }

    @Override
    public void updateTweet(Long tweetId, String message) {
        Tweet tweet = getTweet(tweetId);
        tweet.setMessage(message);
        hibernateConfig.save(tweet);
    }

    @Override
    public void deleteTweet(Long tweetId) {
        Tweet tweet = getTweet(tweetId);
        hibernateConfig.delete(Tweet.class, tweetId);
    }

    @Override
    public List<Tweet> getUserTweets(String userLogin) {
        TypedQuery<Tweet> query = entityManager.createQuery("select t from Tweet t where t.author.login  =:login", Tweet.class);
       return query.setParameter("login", userLogin).getResultList();
    }

    private Tweet getTweet (Long tweetId) {
        return entityManager.find(Tweet.class, tweetId);
    }
}
