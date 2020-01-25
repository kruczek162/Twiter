package utils.namespace.cookie;

import javax.servlet.http.HttpServletRequest;

import static utils.namespace.Namespace.USER_LOGIN;

public class Cokkie {

    public static class Login {
        public  String getUserLoginFromSession(HttpServletRequest req) {
            return (String) req.getSession().getAttribute(USER_LOGIN);
        }
    }
}
