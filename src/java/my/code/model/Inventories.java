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
import my.code.business.User;

/**
 *
 * @author admin
 */
public class Inventories {

        

    private Inventory inv;

    private boolean logged_in;
    DBConnectionManager d;

    public Inventories() {

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

    public Inventories(Inventory inventory, boolean logged_in)
            throws ClassNotFoundException, SQLException {

        this.inv = inventory;
        this.logged_in = false;
        this.d = new DBConnectionManager();
        d.connectToDB();
    }

    public void disconnectDB() {
        d.disconnectDB();
    }


    public Inventory getInventories(String PartNumber) {

        Inventory inv = new Inventory();
        String query = "SELECT PartNumber, VendorUsername, Quantity"
                + "from inventories where inventories.PartNumber = '"
                + PartNumber + "'";
        System.out.println("Query : " + query);
        ResultSet rset = d.execute(query);
        try {
            while (rset != null && rset.next()) {

                inv.setPartnum(rset.getString("PartNumber"));
                inv.setVendoruser(rset.getString("VendorUsername"));
                inv.setQuantity(rset.getInt("Quantity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return inv;

    }

    public void addInventory(String partnum, String vendoruser, int quantity) {
    System.out.println(" "+ partnum + vendoruser + quantity );
        try {
            String query = "INSERT INTO `inventories` (`PartNumber`, `VendorUsername`, `Quantity`) VALUES (?, ?, ?)";
            
            PreparedStatement ps = d.getConnection().prepareStatement(query);
            ps.setString(1, partnum);
            ps.setString(2, vendoruser);
            ps.setInt(3, quantity);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void addtitionInventory(String partpumber, int quantity) {
  
        try {
            String query = "UPDATE `inventories` SET   `Quantity` = `Quantity`+ ? WHERE `PartNumber` = ?";

            PreparedStatement ps = d.getConnection().prepareStatement(query);
            
            ps.setInt(1, quantity);
            ps.setString(2, partpumber);
           

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    

    public void subInventory(String partpumber, int quantity) {
  
        try {
            String query = "UPDATE `inventories` SET   `Quantity` = `Quantity`- ? WHERE `PartNumber` = ?";

            PreparedStatement ps = d.getConnection().prepareStatement(query);
            
            ps.setInt(1, quantity);
            ps.setString(2, partpumber);
           

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteInventory(String partnum) {

        try {
            String query3 = "DELETE FROM `inventories` WHERE PartNumber =?";

            PreparedStatement ps;
     

            ps = d.getConnection().prepareStatement(query3);
            ps.setString(1, partnum);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Inventory> getInventories() {

        List<Inventory> inventories = new ArrayList<Inventory>();

        String query = "SELECT PartNumber, VendorUsername, Quantity from inventories";

        ResultSet rset = d.execute(query);
        try {
            while (rset != null && rset.next()) {
                Inventory inv = new Inventory();
                inv.setPartnum(rset.getString("PartNumber"));
                inv.setVendoruser(rset.getString("VendorUsername"));
                inv.setQuantity(rset.getInt("Quantity"));
                inventories.add(inv);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return inventories;

    }
    
     public List<Inventory> getInventoriesBleow() {

        List<Inventory> inventories = new ArrayList<Inventory>();

        String query = "SELECT PartNumber, VendorUsername, Quantity from inventories";

        ResultSet rset = d.execute(query);
        try {
            while (rset != null && rset.next()) {
                Inventory inv = new Inventory();
                inv.setPartnum(rset.getString("PartNumber"));
                inv.setVendoruser(rset.getString("VendorUsername"));
                
                if(rset.getInt("Quantity") < 10)
                {
                
                    inv.setQuantity(15-(rset.getInt("Quantity")));   
                    inventories.add(inv);
                }
              
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return inventories;

    }
    

    
    
    public void sendEmailQuant (int currentQuant, String email, String partnumber){
        
        
        if (currentQuant<10) {
       
                String body ="Hello We like to info you that we need more"+partnumber;//Body of the mail
		String from ="df.dfm220@gmail.com"; // email of sender
		String sub ="Inventories needs";// subject of the mail
		String id = "df.dfm220@gmail.com"; // email of the sender
		String pass = "442211Mio"; // password of the sender's email
		String to = email;// email of the reciever
		GMailSender sender = new GMailSender(id, pass);
		
		try {
			sender.sendMail(sub, body, from, to);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        }
            
            
    }
    
    
    public String getEmail(String passvendorUser)
    {
        
        String emailVendor="";
        try {
             String query7 = ("SELECT Email from users where UserName = ?");

            PreparedStatement ps = d.getConnection().prepareStatement(query7);
            ps.setString(1, passvendorUser);
            ResultSet rset = ps.executeQuery();
            
            
             while (rset != null && rset.next()) {
                
                emailVendor = rset.getString("Email");//rset.getString("Email"); //rset.getString("Eamil");
                
             }
             ps.close();
        
        } catch (SQLException e) {
           e.printStackTrace();

       }
        
        return emailVendor;
        
    }
    
    
    public int getQuantity(String partnum) {

        int bb=0;
        
        try {
             String query5 = ("SELECT Quantity from inventories where PartNumber = ?");

            PreparedStatement ps = d.getConnection().prepareStatement(query5);
            ps.setString(1, partnum);
            ResultSet rset = ps.executeQuery();
            
            
             while (rset != null && rset.next()) {
                
                bb = rset.getInt("Quantity");
                System.out.println(" " +bb);
             }
             ps.close();
        
        } catch (SQLException e) {
           e.printStackTrace();

       }
       return bb;
          

    }
    
    
}
    

        

