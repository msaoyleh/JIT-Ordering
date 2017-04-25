/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.code.business;

/**
 *
 * @author admin
 */
public class Order {
    
    
    private String partnum;
    private String vendoruser;
    private int quantity;
    private String stock;

    public Order(String partnum, String vendoruser, int quantity, String stock) {
        this.partnum = partnum;
        this.vendoruser = vendoruser;
        this.quantity = quantity;
        this.stock = stock;
    }

       
    
    

    public Order() {
         this.partnum = "";
        this.vendoruser = "";
        this.quantity = 0;
        this.stock = "";
        
    }
    
    
    
    
    public String getPartnum() {
        return partnum;
    }

    public void setPartnum(String partnum) {
        this.partnum = partnum;
    }

    public String getVendoruser() {
        return vendoruser;
    }

    public void setVendoruser(String vendoruser) {
        this.vendoruser = vendoruser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
 
    
    
    
    
    
    
    
    
    
    
    
    
}
