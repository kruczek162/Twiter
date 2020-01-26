<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background: #f5f5f5
        }
        .blue {
            background-color: #00b5ec !important;
        }
    </style>
</head>
<body>
<main role="main" class="container">
    <div class="my-3 p-3 bg-white rounded box-shadow">
        <h4 class="text-center mb-4 mt-1">Sign up</h4>
        <hr>

        <c:if test="${errors != null}">
            <c:forEach items="${errors}" var="error">
                <div class="alert alert-warning">
                    <h6>${error.header}</h6>
                    <h8>${error.message}</h8>
                </div>
            </c:forEach>
        </c:if>

        <form action="register" method="POST" onsubmit="return checkPasswordIdentiti(this)">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="login" class="form-control" placeholder="Login" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="name" class="form-control" placeholder="First name" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="lastName" class="form-control" placeholder="Surname" type="text" required>
                </div>
            </div>


            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="password" class="form-control" placeholder="Password" type="password" aria-required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="repeatedPassword" class="form-control" placeholder="Repeated password" type="password"
                           required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="email" class="form-control" placeholder="email" type="email" required>
                </div>

                <div class="form-group"></div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block blue"> Sign up</button>
                </div>
                <p class="text-center"><a href="login" class="btn">Back to login page</a></p>
            </div>


        </form>
    </div>
</main>
</body>

<script>
    function checkPasswordIdentiti(form) {
        console.log(form.password + form.repeatedPassword)
        if (form.password.value != form.repeatedPassword.value) {
            alert("Password are not equals");
            return false;
        }
        return true;
    }
</script>
</html>