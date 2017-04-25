
        <%@include file="/sVisorHeader.jsp"%>
        <%@include file="/sVisorTopNav.jsp"%>
        <%@include file="/sVisorSideNav.jsp"%>
        
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>
                    <div class="row placeholders">
                </div>
                    <h2 class="sub-header">Add New Vendor&nbsp;<br></h2>
            <form class="form-horizontal" name= "bio" action="mainServlet" method="POST">
            <div class="form-group">
                <label for="fullName" class="col-sm-2 control-label">Full Name </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="fullName" placeholder="fullName" name='fullname'>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password: </label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="password" placeholder="password" name="password">
                </div>
            </div> 
            <div class="form-group">
                <label for="vendorID" class="col-sm-2 control-label">Vendor ID Number: </label>
                <div class="col-sm-4">
                    <input type="vendorID" class="form-control" id="vendorID" placeholder="vendorID" name="vendorID">
                </div>
            </div>
             <div class="form-group">
                <label for="companyName" class="col-sm-2 control-label">Company Name: </label>
                <div class="col-sm-4">
                    <input type="companyName" class="form-control" id="companyName" placeholder="companyName" name="companyName">
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Description: </label>
                <div class="col-sm-4">
                    <textarea class="form-control" rows="5" id="bio" placeholder="Description" name="description"></textarea>
                </div>
            </div>
           
            
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="action" value="addVendor" />
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
                
            </form>
                </div>
            </div>
        </div>
        
        
       
    </body>
</html>
