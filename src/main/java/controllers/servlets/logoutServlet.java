package controllers.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controllers.servlets.util.ServletsUtil.USER_LOGIN;
import static controllers.servlets.util.ServletsUtil.USER_PASSWORD;


@WebServlet (name = "Logout" , value = "/logout")
public class logoutServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        for (Cookie c : req.getCookies()){
            if (c.getName().equals(USER_LOGIN) || c.getName().equals(USER_PASSWORD)){
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }




}
