<%-- 
    Document   : sVisorAddUser
    Created on : Apr 10, 2017, 11:31:00 AM
    Author     : admin
--%>


        <%@include file="/sVisorHeader.jsp"%>
        <%@include file="/sVisorTopNav.jsp"%>
        <%@include file="/sVisorSideNav.jsp"%>
        
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>
                    <div class="row placeholders">
                </div>
                    <h2 class="sub-header">Add New User&nbsp;<br></h2>
            <form class="form-horizontal" name= "bio" action="MainServlet" method="Post">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">First Name </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="firstname" placeholder="" name='firstname'>
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">Last Name </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="lastname" placeholder="" name='lastname'>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email:  </label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" id="emailID"  name="email">
                </div>
            </div>
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Username:  </label>
                <div class="col-sm-4">
                    <input type="username" class="form-control" id="usernameID" name="username">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password: </label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="password"  name="password">
                </div>
            </div> 
                

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Role:  </label>
                <div class="col-sm-4">
                    <select  type="role" class="form-control" id="role" name="role">
                        <option>Supervisor</option>
                        <option>Vendor</option>
                    </select>
                </div>
            </div>
                
                

            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="action" value="adduser" />
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
                
            </form>
                </div>
            </div>
        </div>
        
        
       
    </body>
</html>
