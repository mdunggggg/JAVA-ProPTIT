package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable {
    private Customer customer;
    private Room room;
    private Date dateCheckIn;

    public Order(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
        this.dateCheckIn = new Date();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd:MM:yyyy");
        String date = formatter.format(dateCheckIn);
        return "Order{" +
                "customer=" + customer +
                ", room=" + room +
                ", dateCheckIn=" + date +
                '}';
    }
}
