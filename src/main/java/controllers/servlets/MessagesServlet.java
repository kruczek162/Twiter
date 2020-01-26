package controllers.servlets;

/***
 * Method doGet() calls doPost() because it is easy way to handle refreshing messages.jsp after adding and removing messages.
 * Those servlets (DeleteMessageServlet and AddMessageServlet) are using POST methods to manipulate database records (Tweet.class).
 * After our logic we using dispatcher to redirect to messages servlet , after that operation first called method in servlet is doPost()
 * because in request header is information about request method. That header is used to call right method from servlet. That header is set by us when we click link (GET)
 * sending form (POST) and on server side when we call those method from other for example calling doPost() in doGet() changing this METHOD header to POST.
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */


import controllers.servlets.util.ServletsUtil;
import model.Tweet;
import services.implementation.TweetMenagerServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;


@WebServlet (name = "MessagesServlet" , value = "/messages")
public class MessagesServlet extends HttpServlet {

    TweetMenagerServicesImpl services;

    @Override
    public void init() throws ServletException {

        services = new TweetMenagerServicesImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String curentUserLogin = ServletsUtil.getUserLoginFromSession(req);
        List<Tweet> followedTweets = services.getFollowedTweets(curentUserLogin);
        req.setAttribute(ServletsUtil.FOLLOWED_TWEETS, followedTweets);
        req.getRequestDispatcher("/messages.jsp").forward(req, resp);

    }


}
