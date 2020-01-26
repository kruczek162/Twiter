package controllers.servlets;


import controllers.servlets.util.ServletsUtil;
import services.implementation.UserManagmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controllers.servlets.util.ServletsUtil.USER_lOGIN_TO_FOLLOW;
import static controllers.servlets.util.ServletsUtil.USER_lOGIN_TO_UN_FOLLOW;

@WebServlet(name = "UnFollowServlet", value = "/unfollow")
public class UnFollowServlet extends HttpServlet {
    UserManagmentServiceImpl service;

    @Override
    public void init() throws ServletException {
        service = new UserManagmentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currentUserLogin = ServletsUtil.getUserLoginFromSession(req);
        String userLoginToFallow = req.getParameter(USER_lOGIN_TO_UN_FOLLOW);
        service.stopFollowing(currentUserLogin, userLoginToFallow);
        req.getRequestDispatcher("users").forward(req, resp);

    }


}
