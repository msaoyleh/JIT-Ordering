<%-- 
    Document   : ShowArray
    Created on : Apr 4, 2017, 4:30:50 PM
    Author     : mustafasaoyleh
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="NavServlet" method="doGet">
            
            
            
            <input type="hidden" name="action" value="ShowArray"/>
            <input type="submit" value="submit" />
        </form>
        
        <c:if test="${arraycontect != null}">
            
            <c:forEach var="li" items="${arraycontect}">
                <p> ${li.getName()}</p>
                <p> ${li.getPassword()}</p>
                <p> ${li.getUsername()}</p>
                <p> ${li.getRole()}</p>
            </c:forEach>
            
        </c:if>
        
        
        
    </body>
</html>
