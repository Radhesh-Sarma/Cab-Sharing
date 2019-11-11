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
public class Driver {
    private String driverName;
    private int driverId;
    private String phoneNumber;
    private int rating;
    private String vehicleNumber;
    private String vehicleName;
    private int location;
    private int isBusy;

    public Driver(String driverName, int driverId, String phoneNumber, int rating, String vehicleNumber, String vehicleName, int location, int isBusy) {
        this.driverName = driverName;
        this.driverId = driverId;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.location = location;
        this.isBusy = isBusy;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverId() {
        return this.driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return this.vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getLocation() {
        return this.location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getIsBusy() {
        return this.isBusy;
    }

    public void setIsBusy(int isBusy) {
        this.isBusy = isBusy;
    }
    

}
