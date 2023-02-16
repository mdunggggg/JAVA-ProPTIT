import java.util.Scanner;

public class Truck extends Vehicle{
    private  int payload;

    public Truck(String ID, String manufacturer, String color, String year, int price, int payload) {
        super(ID, manufacturer, color, year, price);
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\n" +
                "Hang san xuat: " + manufacturer + "\n" +
                "Mau: " + color + "\n" +
                "Nam san xuat: " + year + "\n" +
                "Gia ban: " + price +
                "Tai trong: " + payload ;
    }
}