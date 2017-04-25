<%-- 
    Document   : newuser
    Created on : Mar 9, 2017, 1:39:09 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="MainServlet" method="POST">
            First Name : <input type="text" name="firstname" value="" /> <br>
            Last Name : <input type="text" name="lastname" value="" /><br>
            Email   : <input type="text" name="email" value="" /><br>
            User Name : <input type="text" name="username" value="" /><br>
            Password : <input type="text" name="password" value="" /><br>
            <input type="hidden" name="action" value="adduser" />
            
            <input type="submit" value="Add User" />
        </form>
        
        
        <br>
        <p>
             <table border="1">
            <th>First Name</th>
            <th>Last Name Name</th>
            <th>Email</th>
            <th>User Name</th>
            <th>Password</th>
            
             <c:forEach items="${users}" var="user">
          <tr>  
              <td>${user.firstname}</td>
              <td>${user.lastname}</td>
              <td>${user.email}</td>
              <td>${user.username}</td>
               <td>${user.password}</td>
           </tr> 
        </c:forEach>
             </table>
            
            
        </p>
    </body>
</html>
