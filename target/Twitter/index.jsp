<%@ page import="utils.namespace.Namespace" %>
<%@ page import="static utils.namespace.Namespace.*" %>
<html>
<body>
<% String helloUser = ((request.getAttribute(LOGGED_USER) == null) ? "unknown user" :
        request.getAttribute(LOGGED_USER).toString());%>
<h3>Hello <%=helloUser%></h3>
<p><a href="register">Register user</a></p>
<p><a href="login">Login</a></p>
<p><a href="getAllUser">Show users</a></p>
<p><a href="exit">Bye</a></p>
</body>
</html>