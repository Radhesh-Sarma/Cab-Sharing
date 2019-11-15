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
    private String rating;
    private String vehicleNumber;
    private String vehicleName;
    private int location;
    private int isBusy;
    private int numberoftrips;
    public Driver(String driverName, int driverId, String phoneNumber, String rating, String vehicleNumber, String vehicleName, int location, int isBusy, int numberoftrips) {
        this.driverName = driverName;
        this.driverId = driverId;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.location = location;
        this.isBusy = isBusy;
        this.numberoftrips = numberoftrips;
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

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
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

    public int getNumberoftrips() {
        return this.numberoftrips;
    }

    public void setNumberoftrips(int numberoftrips) {
        this.numberoftrips = numberoftrips;
    }    
}
