<%-- 
    Document   : sVisorInventoryRep
    Created on : Apr 10, 2017, 9:11:54 PM
    Author     : admin
--%>


<%@include file="/sVisorHeader.jsp"%>
<%@include file="/sVisorTopNav.jsp"%>
<%@include file="/sVisorSideNav.jsp"%>


<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard</h1>
    <div class="row placeholders">   
    </div>
    <h2 class="sub-header">Inventory Report&nbsp;<br></h2>
   

    <table border="5" width="1000" cellspacing="30" cellpadding="2">
        <!-- here should go some titles... -->
        <tr>
            <th>Part Number</th>
            <th>Vendor Username</th>
            <th>Quantity</th>        
        </tr>
         <!-- here should go some value... -->
            
           <c:forEach items="${users}" var="user">
          <tr>  
              <td>${user.partnum}</td>
              <td>${user.vendoruser}</td>
              <td>${user.quantity}</td>

        </c:forEach>

    </table>
    
    
    
    
       <form action="MainServlet" method="POST">
    
      <input type="hidden" name="action" value="invReport" />
            <input type="submit" value="Update" />
        </form>


</div>
</div>
</div>

</body>