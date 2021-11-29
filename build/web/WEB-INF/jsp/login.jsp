<%@include file="/WEB-INF/jsp/include.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SI5B | Login</title>
        <%@include file="/WEB-INF/jsp/style.jsp"%>
    </head>
    <body>
        <div id="particles-js">
            <div class="custom-form p-4 rounded-3 shadow bg-light">
                <form modelAttribute="emp" method="POST" class="text-center">
                    <img class="mb-4 mx-auto d-block" src="https://stmik.ipem.ac.id/stmik/img/logo.png" alt="" height="120" width="121">
                    <h1 class="h3 mb-3 fw-normal">Silahkan Login Terlebih Dulu</h1>
                    <div class="form-floating">
                        <input class="form-control" type="text" id="username" name="username" placeholder='username'>
                        <label for="username">Username</label>
                    </div>
                    <div class="form-floating">
                        <input class="form-control" type="password" id="password" name="password" placeholder="password">
                        <label for="password">Password</label>
                    </div>
                    ${message != null ? message : "<label class='w-100 my-2 alert alert-warning'>Pastikan semua form terisi!</label>"}
                    <input class="w-100 btn btn-lg btn-primary" type="submit" value="Login">
                </form>
            </div>
        </div>

        <%@include file="/WEB-INF/jsp/particles.jsp"%>
    </body>
</html>
