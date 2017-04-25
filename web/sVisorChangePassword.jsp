
       <%@include file="/sVisorHeader.jsp"%>
        <%@include file="/sVisorTopNav.jsp"%>
        <%@include file="/sVisorSideNav.jsp"%>
        
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>
                    <div class="row placeholders">
</div>
                    <h2 class="sub-header">Change Password&nbsp;<br></h2>
            <form class="form-horizontal" name= "bio" action="form2PostPic" method="POST">
            <div class="form-group">
                <label for="currentPassword:" class="col-sm-2 control-label">Enter current Password: </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="currentPassword" placeholder="currentPassword" name='currentPassword'>
                </div>
            </div>
            <div class="form-group">
                <label for="newPassword" class="col-sm-2 control-label">Enter New Password: </label>
                <div class="col-sm-4">
                    <input type="newPassword" class="form-control" id="newPassword" placeholder="newPassword" name="newPassword">
                </div>
            </div> 
             <div class="form-group">
                <label for="confirmNewPassword" class="col-sm-2 control-label">Confirm New Password: </label>
                <div class="col-sm-4">
                    <input type="confirmNewPassword" class="form-control" id="confirmNewPassword" placeholder="confirmNewPassword" name="confirmNewPassword">
                </div>
            </div> 
           
            
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Change Password</button>
                </div>
            </div>
                
        </form>
                </div>
            </div>
        </div>
    </body>
</html>
