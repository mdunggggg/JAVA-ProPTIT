/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Customer {
    public enum CustomerType{
        Student, Family, Company;

        @Override
        public String toString() {
            switch(this){
                case Student -> {
                    return "Học sinh";
                }
                case Family -> {
                    return "Gia đình";
                }
                case Company -> {
                    return "Doanh nghiệp";
                }
                default -> throw new IllegalArgumentException();
                   
            }
       } 
    }
    public enum CustomerSort{
         ID, Name, RentDate;

        @Override
        public String toString() {
            switch (this) {
                case ID:
                    return "Mã KH";
                case Name:
                    return "Họ tên";
                case RentDate:
                    return "Ngày thuê";
                default:
                    throw new AssertionError();
            }
        }
         
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }
    public void setType(String type){
        for(CustomerType ct : CustomerType.values()){
            if(ct.toString().equals(type)){
                this.type = ct;
                return;
            }
        }
        //throw new InvalidInforException("Invalid Customer Type");
    }
    public static int getNUM_CUSTOMER() {
        return NUM_CUSTOMER;
    }

    private static void setNUM_CUSTOMER(int NUM_CUSTOMER) {
        Customer.NUM_CUSTOMER = NUM_CUSTOMER;
    }
    private String name, phone, address, id;
    private CustomerType type;
    private Room rentRoom;
    private Date rentDate;

    public Room getRentRoom() {
        return rentRoom;
    }

    public void setRentRoom(Room rentRoom) {
        this.rentRoom = rentRoom;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }
    public String getRentDateString() {
        return dateFormat.format(rentDate);
    }
    public static int NUM_CUSTOMER = 0;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public Customer(String name, String phone, String address, String type) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.id = String.format("%05d", ++NUM_CUSTOMER);
        setType(type);
    }
    
}
