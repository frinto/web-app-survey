<%-- 
    Document   : survey
    Created on : Sep 27, 2017, 1:05:21 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey</title>
    </head>
    <body>
        <div>
            <form action="${action}" method="post">
                Gender: 
                <select name="gender">
                    <option value="Female" selected>Female</option>
                    <option value="Male">Male</option>
                    <option value="Other">Other</option>
                </select><br>
                Income: <input type="number" name="income" min="0" max="1000000" value="${incomeValue}"></br>
                Age: <input type="number" name="age" min="0" max="120" value="${ageValue}"></br>
                <input type="submit" value="submit">
            </form>
        </div>
        ${messageToSurvey}
        
    </body>
</html>
