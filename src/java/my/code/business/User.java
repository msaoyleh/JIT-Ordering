/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.code.business;

import java.io.Serializable;

/**
 *
 * @author Fadi
 */
public class User implements Serializable {

    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String role;
    private int login;

    public User() {
        this.username = "";
        this.email = "";
        this.firstname = "";
        this.lastname = "";
        password = "";
        this.role ="";
        this.login=0;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String email, String firstname, String lastname, String password, String role, int login) {
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.login = login;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }



}
