/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.Normalizer;

/**
 *
 * @author ADMIN
 */
public class Room {

    public static int getNUM_Room;


    public enum RoomType{
        VIP, HightQuality, Normal;

        @Override
        public String toString() {
            switch (this) {
                case VIP -> {
                    return "VIP";
                }
                case HightQuality -> {
                    return "Chất lượng cao";
                }
                case Normal -> {
                    return "Thường";
                }
                default -> throw new AssertionError();
            }
        }
        
    }
  
    private String id, name;
    RoomType type;
    private static int NUM_ROOM = 0;
    boolean rented = false;
    Customer rentCustomer;

    public Room(String name, String Type) {
        this.id = String.format("%05d", ++NUM_ROOM);
        this.name = name;
        setType(Type);
       
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }
     public void setType(String type){
        for(RoomType rt : RoomType.values()){
            if(rt.toString().equals(type)){
                this.type = rt;
                return;
            }
        }
        //throw new InvalidInforException("Invalid Customer Type");
    }
    public static int getNUM_ROOM() {
        return NUM_ROOM;
    }

    public static void setNUM_ROOM(int NUM_ROOM) {
        Room.NUM_ROOM = NUM_ROOM;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Customer getRentCustomer() {
        return rentCustomer;
    }

    public void setRentCustomer(Customer rentCustomer) {
        this.rentCustomer = rentCustomer;
    }
    
    
    
}
