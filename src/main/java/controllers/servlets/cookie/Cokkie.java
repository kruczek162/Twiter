package controllers.servlets.cookie;

import javax.servlet.http.HttpServletRequest;

import static controllers.servlets.namespace.Namespace.USER_LOGIN;

public class Cokkie {

    public static class Login {
        public  String getUserLoginFromSession(HttpServletRequest req) {
            return (String) req.getSession().getAttribute(USER_LOGIN);
        }
    }
}
