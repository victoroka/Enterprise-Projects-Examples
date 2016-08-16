<%-- 
    Document   : index
    Created on : Aug 5, 2016, 9:20:34 AM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Exercício 1</title>
    </head>
    <body>
        <form action="Controller" method="POST">
            <input type="hidden" name="command" value="User.login"/>
            <p>
                <label for="username">Username</label><br>
                <input type="text" name="username" id="username"/>
            </p>
            <p>
                <label for="password">Password</label><br>
                <input type="password" name="password" id="password"/>
            </p>
            <p>
                <input type="submit" value="LOGIN"/>
            </p>
        </form>
    </body>
</html>
