package controllers.servlets;

import controllers.servlets.util.ServletsUtil;
import services.TweetMenagerServices;
import services.implementation.TweetMenagerServicesImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controllers.servlets.util.ServletsUtil.*;

@WebServlet (name = "AddTweetServlet" , value = "/addMessage")
public class AddTweetServlet extends HttpServlet {
    private TweetMenagerServices services;

    @Override
    public void init(ServletConfig config) throws ServletException {
        services = new TweetMenagerServicesImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLoginFromSession = getUserLoginFromSession(req);
        String message = req.getParameter(TWEET_MESSAGE_PARAM);
        if (message == null ) {
            req.getRequestDispatcher("messages.jsp").forward(req,resp);
            return;
        }
        services.addTweet(userLoginFromSession, message);
        req.getRequestDispatcher("messages").forward(req,resp);

        ;


    }


}
