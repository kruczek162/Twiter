import hibernate.util.HibernateConfig;
import model.Tweet;
import model.User;
import services.TweetMenagerServices;
import services.UserManagmentService;
import services.implementation.TweetMenagerServicesImpl;
import services.implementation.UserManagmentServiceImpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        HibernateConfig instance = HibernateConfig.getInstance();

        User user = new User.Builder().name("Paweł").password("abc").login("kruk").lastName("Lol").email("kruk162").build();
        User user2 = new User.Builder().name("Adam").password("bca").login("nowakowski").lastName("xd").email("kruczek321").build();
        User user3 = new User.Builder().name("Marek").password("def").login("markowski").lastName("omg").email("builder").build();
        User user4 = new User.Builder().name("Piotrek").password("gfr").login("piotrkowski").lastName("xdxdxd").email("factory").build();
        User user5 = new User.Builder().name("Damian").password("asd").login("damianowski").lastName("haha").email("gówno").build();

        UserManagmentService userManagmentService = new UserManagmentServiceImpl();
        userManagmentService.saveUser(user);
        userManagmentService.saveUser(user2);
        userManagmentService.saveUser(user3);
        userManagmentService.saveUser(user4);
        userManagmentService.saveUser(user5);

        userManagmentService.follow(user.getLogin(), user2.getLogin());
        userManagmentService.follow(user2.getLogin(), user3.getLogin());
        userManagmentService.follow(user4.getLogin(), user5.getLogin());
        userManagmentService.follow(user2.getLogin(), user.getLogin());
        userManagmentService.follow(user.getLogin(), user5.getLogin());

        userManagmentService.stopFollowing(user.getLogin(), user2.getLogin());

        userManagmentService.deleteUser(user.getId());

        TweetMenagerServices tweetMenagerServices = new TweetMenagerServicesImpl();

        tweetMenagerServices.addTweet(user2.getLogin(), "To jest pierwszy tweet drugiego usera");
        tweetMenagerServices.addTweet(user2.getLogin(), "To jest drugi tweet drugiego usera");
        tweetMenagerServices.addTweet(user5.getLogin(), "To jest pierwszy tweet piatego usera");

        List<Tweet> followedTweets = tweetMenagerServices.getFollowedTweets(user2.getLogin());
        tweetMenagerServices.deleteTweet(followedTweets.get(1).getId());

        System.out.println(tweetMenagerServices.getFollowedTweets(user5.getLogin()));





    }

}
