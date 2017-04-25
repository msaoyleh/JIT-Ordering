<%-- 
    Document   : sVisorlogInRep
    Created on : Apr 21, 2017, 2:32:51 PM
    Author     : admin
--%>

<%@include file="/sVisorHeader.jsp"%>
<%@include file="/sVisorTopNav.jsp"%>
<%@include file="/sVisorSideNav.jsp"%>


<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard</h1>
    <div class="row placeholders">   
    </div>
    <h2 class="sub-header">User Report&nbsp;<br></h2>
   

    <table border="5" width="1000" cellspacing="30" cellpadding="2">
        <!-- here should go some titles... -->
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Log In</th>
        </tr>
         <!-- here should go some value... -->
          <c:forEach items="${users}" var="user">
          <tr>  
              <td>${user.firstname}</td>
              <td>${user.lastname}</td>
              <td>${user.username}</td>
               <td>${user.login}</td>
           </tr> 
        </c:forEach>
    </table>
    
    
    
    
   
    
      <form action="MainServlet" method="POST">
         
            <input type="hidden" name="action" value="userLogInReport" />
            
            <input type="submit" value="Update" />
        </form>


</div>
</div>
</div>

</body>