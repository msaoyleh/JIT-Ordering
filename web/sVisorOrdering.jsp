<%-- 
    Document   : sVisorOrdering
    Created on : Apr 14, 2017, 8:01:07 PM
    Author     : admin
--%>

        <%@include file="/sVisorHeader.jsp"%>
        <%@include file="/sVisorTopNav.jsp"%>
        <%@include file="/sVisorSideNav.jsp"%>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>
                    <div class="row placeholders">
                </div>
                    <h2 class="sub-header">Order&nbsp;<br></h2>
            <form class="form-horizontal" name= "bio" action="MainServlet" method="Post">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">Part Number: </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="firstname" placeholder="" name='partNum'>
                </div>
            </div>
                
                <div class="form-group">
                <label for="vendorUser" class="col-sm-2 control-label">Vendor UserName: </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="vendorUser" placeholder="" name='vendorUser'>
                </div>
            
           
            <div class="form-group">
                <label for="quantity" class="col-sm-2 control-label">Quantity:  </label>
                <div class="col-sm-4">
                    <select  type="quantity" class="form-control" id="role" name="quantity">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
            </div>
                
                

            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="action" value="updateInventory" />
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
                
            </form>
                </div>
            </div>
        </div>
        
        
        
        
        
    </body>
</html>
