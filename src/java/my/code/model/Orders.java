/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.code.model;


import Mail.Packages.GMailSender;
import static java.rmi.server.LogStream.log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.code.business.Inventory;
import my.code.business.Order;

/**
 *
 * @author admin
 */
public class Orders {
    int id =0;
    
        private Inventory inv;

    private boolean logged_in;
    DBConnectionManager d;

    public Orders() {

        this.inv = new Inventory();
        this.logged_in = false;
        try {
            this.d = new DBConnectionManager();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.connectToDB();
        System.out.print("connected ..");
        log("Users-connected ");
    }

    public Orders(Inventory inventory, boolean logged_in)
            throws ClassNotFoundException, SQLException {

        this.inv = inventory;
        this.logged_in = false;
        this.d = new DBConnectionManager();
        d.connectToDB();
    }

    public void disconnectDB() {
        d.disconnectDB();
    }
    
     public List<Order> getOrders() {

        List<Order> orders = new ArrayList<Order>();

        String query = "SELECT PartNumber, VendorUsename, Quantity, Stock from orders";

        ResultSet rset = d.execute(query);
        try {
            while (rset != null && rset.next()) {
                Order ord = new Order();
                ord.setPartnum(rset.getString("PartNumber"));
                ord.setVendoruser(rset.getString("VendorUsename"));
                ord.setQuantity(rset.getInt("Quantity"));
                ord.setStock(rset.getString("Stock"));
               
                orders.add(ord);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return orders;

    }
    
     public void addOrder(String partnum, String vendoruser, int quantity, String stock) {
    System.out.println(" "+ partnum + vendoruser + quantity );
     
        try {
            String query = "INSERT INTO `orders` (`PartNUmber`, `VendorUsename`, `Quantity`, `Stock`) VALUES (?, ?, ?,?)";
            
            PreparedStatement ps = d.getConnection().prepareStatement(query);
            ps.setString(1, partnum);
            ps.setString(2, vendoruser);
            ps.setInt(3, quantity);
            ps.setString(4, stock);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    
    
    
}
