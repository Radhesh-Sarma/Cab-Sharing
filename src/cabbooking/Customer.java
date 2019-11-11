/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabbooking;

/**
 *
 * @author radhesh
 */
public class Customer {
    
    private String name;
    private String address;
    private String email;
    private String username;
    private String password;
    private int balance;
    private String dob;
    private int isBusy;
    private String phonenumber;

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", balance='" + getBalance() + "'" +
            ", dob='" + getDob() + "'" +
            ", isBusy='" + getIsBusy() + "'" +
            ", phonenumber='" + getPhonenumber() + "'" +
            "}";
    }

    public Customer(String name, String address, String email, String username, String password, int balance, String dob, int isBusy, String phonenumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.dob = dob;
        this.isBusy = isBusy;
        this.phonenumber = phonenumber;
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getIsBusy() {
        return this.isBusy;
    }

    public void setIsBusy(int isBusy) {
        this.isBusy = isBusy;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
 
 
}
