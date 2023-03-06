/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Customer;
import Model.Room;
import Model.table.CustomerTableModel;
import Model.table.RoomTableModel;
import java.util.Date;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class Manager {
    private static Manager instance;
    private final CustomerTableModel customerTable;
    private final RoomTableModel roomTableModel;
    public TableModel getCustomerTable;
    private Manager(){
        this.customerTable = new CustomerTableModel();
        this.roomTableModel = new RoomTableModel();
    }
    public static Manager getInstance(){
        if(instance == null) instance = new Manager();
        return instance;
    }

    public CustomerTableModel getCustomerTable() {
        return customerTable;
    }
    public RoomTableModel getRoomTableModel(){
        return roomTableModel;
    }
    public void addCustomer(String name, String address, String phone, String type){
        customerTable.addCustomer(name, address, phone, type);
    }
    public String countCustomer(){
        return String.format("%05d", Customer.getNUM_CUSTOMER() + 1);
    }
    public String countRoom(){
        return String.format("%05d", Room.getNUM_ROOM() + 1);
    
    }
    public void addRoom(String name, String type){
        roomTableModel.addRoom(name, type);
    }
    public void update(){
        customerTable.fireTableDataChanged();
        roomTableModel.fireTableDataChanged();
    }
    public void bookRoom(String idCustomer, String idRoom){
        Customer customer = customerTable.findCustomer(idCustomer);
        Room room = roomTableModel.findRoom(idRoom);
        if(customer.getRentRoom() != null) return;
        if(room.isRented() == true) return;
        customer.setRentRoom(room);
        customer.setRentDate(new Date());
        room.setRented(true);
        update();
    }
    public void checkOut(String id){
        Customer customer = customerTable.findCustomer(id);
        if(customer.getRentRoom() == null) return;
        Room room = customer.getRentRoom();
        room.setRented(false);
        customer.setRentRoom(null);
        customer.setRentDate(null);
        update();
    }
    public void updateCustomer(String id, String name, String address, String phone, String type){
        Customer customer = customerTable.findCustomer(id);
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setType(type);
        customerTable.fireTableDataChanged(); 
    }
    public void updateRoom(String id, String name, String type){
        Room room = roomTableModel.findRoom(id);
        room.setName(name);
        room.setType(type);
        roomTableModel.fireTableDataChanged();
    }
    
   
    
}
