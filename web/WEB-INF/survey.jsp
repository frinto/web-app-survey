<%-- 
    Document   : survey
    Created on : Sep 27, 2017, 1:05:21 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey</title>
    </head>
    <body>
        <div>
            <form action="surveyComplete" method="post">
                Gender: 
                <select name="gender">
                    <option value="Female" selected>Female</option>
                    <option value="Male">Male</option>
                    <option value="Other">Other</option>
                </select><br>
                Income: <input type="number" name="income" value="${incomeValue}"></br>
                Age: <input type="number" name="age" value="${ageValue}"></br>
                <input type="submit" value="submit">
            </form>
        </div>
    </body>
</html>
