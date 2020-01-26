package controllers.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static  controllers.servlets.util.ServletsUtil.*;

@WebServlet (name = "ViewProfileUser" , value = "/viewProfile")
public class ViewProfileUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loginToViewProfile = req.getParameter(USER_LOGIN_TO_VIEW_PROFILE);
        req.getRequestDispatcher("/viewProfileUser.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {

    }
}
