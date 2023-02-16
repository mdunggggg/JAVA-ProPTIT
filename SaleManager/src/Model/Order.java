package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private static int NUM_ORDER = 0;
    private String id_order;
    private String id_Item;
    private String id_Customer;
    private String id_Staff;
    private int number;
    private Date timeCreated;

    public Order(String id_Item, String id_Customer, String id_Staff, int number) {
        ++NUM_ORDER;
        this.id_order = "0".repeat(6 - String.valueOf(NUM_ORDER).length()) + String.valueOf(NUM_ORDER);
        this.id_Item = id_Item;
        this.id_Customer = id_Customer;
        this.id_Staff = id_Staff;
        this.number = number;
        this.timeCreated = new Date();
    }

    public static int getNumOrder() {
        return NUM_ORDER;
    }

    public static void setNumOrder(int numOrder) {
        NUM_ORDER = numOrder;
    }

    public String getId() {
        return id_order;
    }

    public void setId(String id) {
        this.id_order = id;
    }

    public String getId_Item() {
        return id_Item;
    }

    public void setId_Item(String id_Item) {
        this.id_Item = id_Item;
    }

    public String getId_Customer() {
        return id_Customer;
    }

    public void setId_Customer(String id_Customer) {
        this.id_Customer = id_Customer;
    }

    public String getId_Staff() {
        return id_Staff;
    }

    public void setId_Staff(String id_Staff) {
        this.id_Staff = id_Staff;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd:MM:yyyy");
        String date = formatter.format(timeCreated);
        return "ID: " + id_order + "\t" +
                "Id item: " + id_Item + "\t" +
                "Id customer: " + id_Customer + "\t" +
                "Id staff: " + id_Staff + "\t"+
                "Number: " + number + "\t" +
                "Transaction time: " + date;
    }
}
