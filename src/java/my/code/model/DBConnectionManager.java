/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.code.model;

/**
 * This class is used to open a connection to the application database, the class
 * is used by the restaurant.model classes
 * @author Fadi
 */
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBConnectionManager {

    private Connection connection;
    private String dbURL;
    private String user;
    private String pwd;
    Statement stat;

    //paramatrized constructor
    public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException {

        this.dbURL = dbURL;
        this.user = user;
        this.pwd = pwd;

    }

    //default constructor where values are obtained from the contstants class
    public DBConnectionManager() throws ClassNotFoundException, SQLException {

        this.dbURL = Constants.dbURL;
        this.user = Constants.user;
        this.pwd = Constants.pwd;

    }

    //this method initiate the database connection
    public void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.err.println(e);
            System.exit(-1);
        }
        try {
            System.out.println(Constants.dbURL +" "+ Constants.user +" "+ Constants.pwd);
            //connection = DriverManager.getConnection("jdbc:oracle:thin:@" + this.hostName + ":" + this.port +":"+ this.SID + "," +  this.userName + "," + this.password);
            this.connection = DriverManager.getConnection(Constants.dbURL, Constants.user, Constants.pwd);
            stat = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    

    //returns the currnet database connection
    public Connection getConnection() {
        return this.connection;
    }

    //this method executes query string and return back the result set
    public ResultSet execute(String SQL) {
        ResultSet rs;
        try {
            rs = stat.executeQuery(SQL);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //this method executes database insert queries
    public void insert(String SQL) {
        Statement stat;
        try {
            stat = connection.createStatement();
            stat.executeQuery(SQL);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //this closes the connection to the database
    public void disconnectDB() {
        try {

            stat.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
