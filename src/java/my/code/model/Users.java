/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.code.model;

import Mail.Packages.GMailSender;
import static java.rmi.server.LogStream.log;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import my.code.business.User;

/**
 * This class is used to perform different operations on the Users database
 * table.
 *
 * @author Fadi
 */
public class Users {

    private User usr;

    private boolean logged_in;
    DBConnectionManager d;

    public Users() {

        this.usr = new User();
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

    public Users(User user, boolean logged_in)
            throws ClassNotFoundException, SQLException {

        this.usr = user;
        this.logged_in = false;
        this.d = new DBConnectionManager();
        d.connectToDB();
    }

    public void disconnectDB() {
        d.disconnectDB();
    }

    public boolean valicdateUser(String UserName, String UserPassword) {
        boolean valid = false;
        String query = "SELECT UserPassword from users where users.UserName = '" + UserName + "'";
        //System.out.println("user name : " + UserName);
        ResultSet rset = d.execute(query);

        try {

            while (rset.next()) {
                String pass = rset.getString("UserPassword");
                // System.out.println("user password : " + pass);
                valid = pass.equals(UserPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
    
    
    public void loginCount(String Username) {
  
        try {
            String query = "UPDATE `users` SET   `Timeslogin` = `Timeslogin`+ 1 WHERE `UserName` = ?";

            PreparedStatement ps = d.getConnection().prepareStatement(query);
            
            ps.setString(1, Username);
            
           

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public boolean roleUser(String UserName) {
        boolean valid = false;
        String query = "SELECT Role from users where users.UserName = '" + UserName + "'";
        //System.out.println("user name : " + UserName);
        ResultSet rset = d.execute(query);

        try {

            while (rset.next()) {
                String pass = rset.getString("Role");
                // System.out.println("user password : " + pass);
                valid = pass.equals("Supervisor");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
    
    
    
        public void sendEmailNewAccount (String name, String email){
        
        
                String body ="Hello,"+name+" Please confirm your email address to activate your account and start tracking your Orders.\n" +
"JIT is the smart way to order and track orders and more. Let us show you how it works.";//Body of the mail
		String from ="df.dfm220@gmail.com"; // email of sender
		String sub ="Welvome to JIT";// subject of the mail
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
        
        

    public User getUser(String UserName) {

        User usr = new User();
        String query = "SELECT UserName, Email, FirstName, LastName, UserPassword, Role, Timeslogin"
                + "from users where users.UserName = '"
                + UserName + "'";
        System.out.println("Query : " + query);
        ResultSet rset = d.execute(query);
        try {
            while (rset != null && rset.next()) {

                usr.setUsername(rset.getString("UserName"));
                usr.setFirstname(rset.getString("FirstName"));
                usr.setLastname(rset.getString("LastName"));
                usr.setEmail(rset.getString("Email"));
                usr.setPassword(rset.getString("UserPassword"));
                usr.setRole(rset.getString("Role"));
                usr.setLogin(rset.getInt("Timeslogin"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return usr;

    }

    public void addUser(String firstname, String lastname, String email, String username, String pass, String role) {
System.out.println(" "+ firstname + lastname + email + username + pass);
        try {
            String query = "INSERT INTO `users` (`UserName`, `UserPassword`, `Email`, `FirstName`, `LastName`, `Role`,`Timeslogin` ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = d.getConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, firstname);
            ps.setString(5, lastname);
            ps.setString(6, role);
            ps.setInt(7, 0);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
    public void updateUser(String firstname, String lastname, String email, String username, String pass) {

        try {
            String query = "UPDATE `users` SET  `UserPassword` = ?, `Email` = ?, `FirstName`= ?, `LastName`= ? WHERE `UserName` = ?";

            PreparedStatement ps = d.getConnection().prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, email);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, username);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    */

    public void deleteUser(String username) {

        try {
            String query3 = "DELETE FROM `users` WHERE UserName =?";

            PreparedStatement ps;
     

            ps = d.getConnection().prepareStatement(query3);
            ps.setString(1, username);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getUsers() {

        List<User> users = new ArrayList<User>();

        String query = "SELECT UserName, Email, FirstName, LastName, Role, UserPassword, Timeslogin from users";

        ResultSet rset = d.execute(query);
        try {
            while (rset != null && rset.next()) {
                User usr = new User();
                usr.setUsername(rset.getString("UserName"));
                usr.setFirstname(rset.getString("FirstName"));
                usr.setLastname(rset.getString("LastName"));
                usr.setEmail(rset.getString("Email"));
                usr.setPassword(rset.getString("UserPassword"));
                usr.setRole(rset.getString("Role"));
                usr.setLogin(rset.getInt("Timeslogin"));
                users.add(usr);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return users;

    }

}
