<%-- 
    Document   : AddUser
    Created on : Apr 7, 2017, 2:43:25 PM
    Author     : mustafasaoyleh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
        
        <form action="NavServlet" method="Get">
            
            Name: <input type="text" name="Name" value="" />
            
            Password: <input type="text" name="Password" value="" />
            
            Email: <input type="text" name="Email" value="" />
            
            Role: <input type="text" name="Role" value="" />
            
            
            <input type="hidden" name="action" value="sVisorAddVen"/>
            <input type="submit" value="submit" />
        </form>
                
        

    </body>
</html>
