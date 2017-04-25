<%-- 
    Document   : vendorOrdering
    Created on : Apr 19, 2017, 10:47:47 PM
    Author     : admin
--%>

       <%@include file="/vendorHeader.jsp"%>
        <%@include file="/vendorTopNav.jsp"%>
        <%@include file="/vendorSideNav.jsp"%>
         
        

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>
                    <div class="row placeholders">   
                    </div>
                    <h2 class="sub-header">Needed &nbsp;<br></h2>
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
    
      <input type="hidden" name="action" value="OrderUndertenReport" />
            <input type="submit" value="Update" />
        </form>
                <h2 class="sub-header">Shipping Inventory&nbsp;<br></h2>
                    <form class="form-horizontal" name= "bio" action="MainServlet" method="Post">
            <div class="form-group">
                <label for="partNum" class="col-sm-2 control-label">Part Number </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="partNum" placeholder="" name='partNum'>
                </div>
            </div>
            
            <div class="form-group">
                <label for="quantity" class="col-sm-2 control-label">Quantity:  </label>
                <div class="col-sm-4">
                    <input type="quantity" class="form-control" id="emailID"  name="quantity">
                </div>
            </div>

            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="action" value="shipInventory" />
                    <button type="submit" class="btn btn-default">Ship  </button>
                </div>
            </div>
                
            </form>
                </div>
            </div>
        </div>
                    
                    
                </div>
            </div>
        </div>
        </body>
        </html>
