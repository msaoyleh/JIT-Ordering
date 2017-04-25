<%-- 
    Document   : sVisorDeleteuser
    Created on : Apr 10, 2017, 1:07:56 PM
    Author     : admin
--%>




<%@include file="/sVisorHeader.jsp"%>
<%@include file="/sVisorTopNav.jsp"%>
<%@include file="/sVisorSideNav.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard</h1>
    <div class="row placeholders">
    </div>
    <h2 class="sub-header">Delete User&nbsp;<br></h2>
    <form class="form-horizontal" name= "bio" action="MainServlet" method="Post">

        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">Username:  </label>
            <div class="col-sm-4">
                <input type="username" class="form-control" id="usernameID" name="username">
            </div>
        </div>
</div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <input type="hidden" name="action" value="deleteUser" />
        <button type="submit" class="btn btn-default">Submit</button>
    </div>
</div>

</form>
</div>
</div>
</div>



</body>
</html>
