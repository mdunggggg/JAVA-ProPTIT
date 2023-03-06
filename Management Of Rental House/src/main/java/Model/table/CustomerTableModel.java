/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.table;

import Model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADMIN
 */
public class CustomerTableModel extends AbstractTableModel{
    private final List<Customer> customers;
    private final String[] columnNames;
   
    public CustomerTableModel() {
        customers = new ArrayList<>();
        columnNames = new String[]{
            "Mãaa", "Họ tên", "Địa chỉ", "Số điện thoại", "Loại KH" , "Mã phòng", "Ngày thuê"
        };
        fakeInfor();
    }

    
    @Override
    public int getRowCount() {
           return customers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Customer customer = customers.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return customer.getId();
            }
            case 1 -> {
                return customer.getName();
            }
            case 2 -> {
                return customer.getAddress();
            }
            case 3 -> {
                return customer.getPhone();
            }
            case 4 -> {
                return customer.getType();
            }
            case 5 -> {
                if (customer.getRentRoom() == null) return "";
                else return customer.getRentRoom().getId();
            }
            case 6 -> {
                if (customer.getRentDate() == null) return "";
                else return customer.getRentDateString();
            }
        }
        return "";
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public void addCustomer(String name, String address, String phone, String type){
        Customer customer = new Customer(name, phone, address, type);
        customers.add(customer);
        fireTableDataChanged();
    }
    public Customer findCustomer(String id){
        for(Customer customer : customers){
            if(customer.getId().equals(id))
               return customer;
        }
        return null;
    }
    public void fakeInfor(){
        customers.add(new Customer("Hoàng Dũng 1", "09192135135", "Hà Nội", "Học sinh"));
        customers.add(new Customer("Hoàng Dũng 2", "09192135135", "Hà Nội", "Học sinh"));
        customers.add(new Customer("Hoàng Dũng 3", "09192135135", "Hà Nội", "Học sinh"));
        customers.add(new Customer("Hoàng Dũng 4", "09192135135", "Hà Nội", "Học sinh"));
        customers.add(new Customer("Hoàng Dũng 5", "09192135135", "Hà Nội", "Học sinh"));
        customers.add(new Customer("Hoàng Dũng 6", "09192135135", "Hà Nội", "Học sinh"));
        customers.add(new Customer("Hoàng Dũng 7", "09192135135", "Hà Nội", "Học sinh"));
        fireTableDataChanged();
        
    }
    
    
}
