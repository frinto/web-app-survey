<%-- 
    Document   : index
    Created on : Sep 27, 2017, 1:07:09 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <h1>Survey</h1>
        <a href ="survey">Complete the survey</a>
        
        <h1>Login</h1>
        <div>
            <form action="index" method="post">
                user name: <input type="text" name="username" value="${username}"></br>
                password: <input type="password" name="password" value="${password}"></br>
                <input type="submit" value="submit">
            </form>
        </div>
        ${errorMessage}
        ${successMessage}
    </body>
</html>
