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
public class Inventory {

  
    private String partnum;
    private String vendoruser;
    private int quantity;

    
    
    

    public Inventory() {
        this.partnum = "";
        this.vendoruser = "";
        this.quantity = 0;

    }
    
    
    public String getPartnum() {
        return partnum;
    }

    public void setPartnum(String partnum) {
        this.partnum = partnum;
    }
    
    
    
      public Inventory(String partnum, String vendoruser, int quantity) {
        this.partnum = partnum;
        this.vendoruser = vendoruser;
        this.quantity = quantity;
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
    
    
    
    
    
}
