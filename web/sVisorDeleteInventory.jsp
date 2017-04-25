

        <%@include file="/sVisorHeader.jsp"%>
        <%@include file="/sVisorTopNav.jsp"%>
        <%@include file="/sVisorSideNav.jsp"%>
        
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>
                    <div class="row placeholders">
                </div>
                    <h2 class="sub-header">Delete Inventory&nbsp;<br></h2>
            <form class="form-horizontal" name= "bio" action="MainServlet" method="Post">
            <div class="form-group">
                <label for="partNum" class="col-sm-2 control-label">Part Number </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="partNum" placeholder="" name='partNum'>
                </div>
            </div>
            
         

            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="action" value="deleteInventory" />
                    <button type="submit" class="btn btn-default">Delete Inventory</button>
                </div>
            </div>
                
            </form>
                </div>
            </div>
        </div>
        
        
       
    </body>
</html>
