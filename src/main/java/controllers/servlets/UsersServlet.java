package controllers.servlets;

import controllers.servlets.util.ServletsUtil;
import model.User;
import services.UserManagmentService;
import services.implementation.UserManagmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static controllers.servlets.util.ServletsUtil.FOLLOWED_USERS;
import static controllers.servlets.util.ServletsUtil.NOTFOLOWED_USERS;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {
    private UserManagmentService service;

    @Override
    public void init() throws ServletException {
        service = new UserManagmentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = ServletsUtil.getUserLoginFromSession(req);
        Set<User> followedUsers = service.getFollowedPUsers(login);
        Set<User> notFollowedUsers = service.getNotFollowedUsers(login);
        req.setAttribute(FOLLOWED_USERS, followedUsers);
        req.setAttribute(NOTFOLOWED_USERS, notFollowedUsers);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }


}
