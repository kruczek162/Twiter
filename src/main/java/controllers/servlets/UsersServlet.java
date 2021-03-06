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
