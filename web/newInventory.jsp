<%-- 
    Document   : newInventory
    Created on : Apr 10, 2017, 2:49:22 PM
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
        <h1></h1>
        <form action="MainServlet" method="POST">
            
            <div class="form-group">
                <label for="partNum" class="col-sm-2 control-label">Part Number: </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="partNum" placeholder="" name='partNum'>
                </div>
            </div>
            
            <div class="form-group">
                <label for="vendorUser" class="col-sm-2 control-label">Vendor UserName: </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="vendorUser" placeholder="" name='vendorUser'>
                </div>
            </div>
            
            <div class="form-group">
                <label for="quantity" class="col-sm-2 control-label">Quantity: </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="quantity" placeholder="" name='quantity'>
                </div>
            </div>
            
            
            <input type="hidden" name="action" value="addInventory" />
            <input type="submit" value="Update" />
        </form>
        
        
        <br>
        <p>
             <table border="1">
            <th>Part</th>
            <th>user Name</th>
            <th>q</th>

            
             <c:forEach items="${users}" var="user">
          <tr>  
              <td>${user.partnum}</td>
              <td>${user.vendoruser}</td>
              <td>${user.quantity}</td>

        </c:forEach>
             </table>
            
            
        </p>
    </body>
</html>
