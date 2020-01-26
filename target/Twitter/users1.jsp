<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Users</title>
</head>
<body>
<h1> ---------------------------------------------------------- FOLLOWED-------------------------------------------</h1>

    <div>
        <c:forEach items="${followedUsers}" var="user">
            <strong>${user.login}</strong><br>
            <strong>${user.password}</strong><br>
            <strong>${user.email}</strong><br>
            <strong>${user.name}</strong><br>
            <strong>${user.lastName}</strong><br>
            <h6>............</h6>
            <strong><fmt:formatDate value="${user.dateOfRegistration}" pattern="yyyy-MM-dd HH-mm"/> </strong><br>

        </c:forEach>
    </div>
<h1>
    ------------------------------------------------------------ NOT FOLLOWED------------------------------------ </h1>

    <div>
        <c:forEach items="${notFolowedUsers}" var="user">
            <strong>${user.login}</strong><br>
            <strong>${user.password}</strong><br>
            <strong>${user.email}</strong><br>
            <strong>${user.name}</strong><br>
            <strong>${user.lastName}</strong><br>
            <strong><fmt:formatDate value="${user.dateOfRegistration}" pattern="yyyy-MM-dd HH-mm"/> </strong><br>
        </c:forEach>
    </div>
</body>
</html>
