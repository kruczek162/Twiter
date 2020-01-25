package controllers.servlets;


import utils.namespace.errors.ValidationError;
import services.implementation.UserManagmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.namespace.Namespace.*;

@WebServlet(name = "LoginServlets", urlPatterns = {"", "/login"})
public class LoginServlet extends HttpServlet {


    private UserManagmentServiceImpl service;
    private List<ValidationError> errors;
    private final int  SECONDS_IN_DAY = 60 * 60 * 24;

    @Override
    public void init() throws ServletException {
        service = new UserManagmentServiceImpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = null;
        String password = null;

        if (null != req && null != req.getCookies()){
            for (Cookie c : req.getCookies()) {
                if (c.getName().equals(USER_LOGIN))
                {
                    login = c.getValue();
                }
                if (c.getName().equals(USER_PASSWORD)){
                    password = c.getValue();
                }
            }
        }


        if (login != null && password != null ){

            req.setAttribute(USER_LOGIN, login);
            req.setAttribute(USER_PASSWORD, password);
            doPost(req, resp);
            return;
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter(USER_LOGIN);
        String password = req.getParameter(USER_PASSWORD);
        boolean isremeberChecked = (CHECKBOOK_CHECKED).equals(req.getParameter(REMEMBER));
        errors = new ArrayList<>();

        if (login == null && password == null) {
            login = (String)req.getAttribute(USER_LOGIN);
            password =(String)req.getAttribute(USER_PASSWORD);
        }


        if (!service.isUserExists(login)) {
            errors.add(new ValidationError(LOGIN_ERROR_HEADER, LOGIN_NOT_EXIST_ERROR_MESSAGE));
            req.setAttribute(ERROR_ATTRIBUTE_NAME, errors);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        if (!service.isUserValid(login, password)) {
            errors.add(new ValidationError(PASSWORD_ERROR_HEADER, WORNG_PASSWORD_ERROR_MESSAGE));
            req.setAttribute(ERROR_ATTRIBUTE_NAME, errors);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute(USER_LOGIN, login);

        if (isremeberChecked){
            Cookie loginCookie = new Cookie(USER_LOGIN, login);
            Cookie passwordCookie = new Cookie(USER_PASSWORD, password);
            loginCookie.setMaxAge(SECONDS_IN_DAY);
            passwordCookie.setMaxAge(SECONDS_IN_DAY);
            resp.addCookie(loginCookie);
            resp.addCookie(passwordCookie);


        }





        req.getRequestDispatcher("users").forward(req, resp);

    }

}