package Model;

public class Customer extends Person{
    private static int NUM_CUSTOMER = 0;
    private String gmail;

    public Customer(String id, String address, String name, String phoneNumber, String gmail) {
        super(id, address, name, phoneNumber);
        this.gmail = gmail;
        ++NUM_CUSTOMER;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t" +
                "Name: " + name + "\t" +
                "Address: " + address + "\t" +
                "Phone: " + phoneNumber + "\t" +
                "Gmail: " + gmail;
    }
}
