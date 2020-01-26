package controllers.servlets;


import services.TweetMenagerServices;
import services.implementation.TweetMenagerServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controllers.servlets.util.ServletsUtil.TWEET_MESSAGE_PARAM;
import static controllers.servlets.util.ServletsUtil.*;

@WebServlet (name = "DeleteTweetServlet" , value = "/deleteTweet")
public class DeleteTweetServlet extends HttpServlet {
    TweetMenagerServices services ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tweetId = req.getParameter(TWEET_MESSAGE_ID_PARAM);
        services.deleteTweet(Long.parseLong(tweetId));
        req.getRequestDispatcher("messages").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        services = new TweetMenagerServicesImpl();

    }
}
