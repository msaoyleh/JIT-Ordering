/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.code.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import my.code.business.Inventory;
import my.code.business.Order;
import my.code.business.User;
import my.code.model.Inventories;
import my.code.model.Orders;
import my.code.model.Users;

/**
 *
 * @author admin
 */
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        
        String action = (String) request.getParameter("action");
        if (action.equalsIgnoreCase("logging")) {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
             
            Cookie c = new Cookie("username", username);
            c.setMaxAge(60 * 60 * 24 * 365 * 2);   // set age to 2 years
            c.setPath("/");                // allow access by entire app
            response.addCookie(c);
            
            Cookie c2 = new Cookie("password", password);
            c.setMaxAge(60 * 60 * 24 * 365 * 2);   // set age to 2 years
            c.setPath("/");                // allow access by entire app
            response.addCookie(c2);
            
            HttpSession session = request.getSession(false);
            if (session == null) // Not created yet. Now do so yourself.   
            {

                session = request.getSession();
                session.setAttribute("username", username);
                

            } else {

                session.invalidate();
                HttpSession session2 = request.getSession(true);
                session2.setAttribute("username", username);
                
            }
            Users usr = new Users();
            if (usr.valicdateUser(username, password))
            {
                if (usr.roleUser(username)){
                    usr.loginCount(username);
                    url = "/sVisorMain.jsp";
                    
                }
                else
                {
                    usr.loginCount(username);
                    url = "/vendorMain.jsp";
                }
                
            }
            else
            {
              url = "/login.jsp";      
            }
             

        }
        else if (action.equalsIgnoreCase("adduser"))
        {
            
            String firstname = (String) request.getParameter("firstname");
            String lastname = (String) request.getParameter("lastname");
            String email = (String) request.getParameter("email");
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            String role = (String) request.getParameter("role");
            Users usr = new Users();
            usr.addUser(firstname, lastname, email, username, password,role);
            usr.sendEmailNewAccount(firstname,email);
            List<User> users = new ArrayList<User>();
            users = usr.getUsers();
            request.setAttribute("users", users);
            url = "/sVisorMain.jsp";
        }
        else if(action.equalsIgnoreCase("deleteUser"))
        {
            String username = (String) request.getParameter("username");
            Users usr = new Users();
            usr.deleteUser(username);
            List<User> users = new ArrayList<User>();
            users = usr.getUsers();
            request.setAttribute("users", users);
            url = "/sVisorMain.jsp";
        }
        else if (action.equalsIgnoreCase("addInventory"))
        {
            String partnum = (String) request.getParameter("partNum");
            String vendoruser = (String) request.getParameter("vendorUser");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Inventories inv = new Inventories();
            inv.addInventory(partnum, vendoruser, quantity);
            List<Inventory> inventories = new ArrayList<Inventory>();
            inventories = inv.getInventories();
            request.setAttribute("users", inventories);
            url = "/sVisorMain.jsp";
        }
        else if(action.equalsIgnoreCase("deleteInventory"))
        {
            String partnum = (String) request.getParameter("partNum");
            Inventories inv = new Inventories();
            inv.deleteInventory(partnum);
            List<Inventory> inventories = new ArrayList<Inventory>();
            inventories = inv.getInventories();
            request.setAttribute("users", inventories);
            url = "/sVisorMain.jsp";
        }
        else if(action.equalsIgnoreCase("userReport"))
        {
            Users usr = new Users();
            List<User> users = new ArrayList<User>();
            users = usr.getUsers();
            request.setAttribute("users", users);
            url = "/sVisorUserRep.jsp";  
        }
         else if(action.equalsIgnoreCase("userLogInReport"))
        {
            Users usr = new Users();
            List<User> users = new ArrayList<User>();
            users = usr.getUsers();
            request.setAttribute("users", users);
            url = "/sVisorlogInRep.jsp";  
        }
         else if(action.equalsIgnoreCase("invReport"))
         {
             
            Inventories inv = new Inventories();
            List<Inventory> inventories = new ArrayList<Inventory>();
            inventories = inv.getInventories();
            request.setAttribute("users", inventories);
            url = "/sVisorInventoryRep.jsp";  
        }
        else if(action.equalsIgnoreCase("updateInventory"))
         {
             
            String partnum = (String) request.getParameter("partNum");
            String vendorUsername =(String) request.getParameter("vendorUser");
            int quantity =  Integer.parseInt(request.getParameter("quantity"));
           Inventories inv = new Inventories();
            Orders ord = new Orders();
            
            inv.subInventory(partnum, quantity);
          
            inv.sendEmailQuant(inv.getQuantity(partnum),inv.getEmail(vendorUsername),partnum );
            
            
            ord.addOrder(partnum,vendorUsername,quantity,"Used");

            List<Inventory> inventories = new ArrayList<Inventory>();
           inventories = inv.getInventories();
            request.setAttribute("users", inventories);
            url = "/sVisorMain.jsp";  
        }
        else if(action.equalsIgnoreCase("shipInventory"))
         {
             
            String partnum = (String) request.getParameter("partNum");
            String vendorUsername = "John1";
            int quantity =  Integer.parseInt(request.getParameter("quantity"));
           Inventories inv = new Inventories();
            Orders ord = new Orders();
            
            inv.addtitionInventory(partnum, quantity);
            
            
            ord.addOrder(partnum,vendorUsername,quantity,"Shipped");

            List<Inventory> inventories = new ArrayList<Inventory>();
           inventories = inv.getInventories();
            request.setAttribute("users", inventories);
            url = "/vendorMain.jsp";  
        }
         else if(action.equalsIgnoreCase("ordReport"))
         {
             
            Orders ord = new Orders();
            List<Order> orders = new ArrayList<Order>();
            orders = ord.getOrders();
            request.setAttribute("users", orders);
            url = "/sVisorOrderRep.jsp";  
        }
        else if(action.equalsIgnoreCase("OrderUndertenReport"))
         {
             
             
             
             
            Inventories inv = new Inventories();
            List<Inventory> inventories = new ArrayList<Inventory>();
            inventories = inv.getInventoriesBleow();
            request.setAttribute("users", inventories);
            url = "/vendorOrdering.jsp"; 
        }
        
        
     
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
