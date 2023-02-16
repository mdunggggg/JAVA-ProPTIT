import java.util.Scanner;

public class Car extends Vehicle{
    private int seats;
    private String engine;
    public Car(String ID, String manufacturer, String color, String year, int price, int seats, String engine) {
        super(ID, manufacturer, color, year, price);
        this.seats = seats;
        this.engine = engine;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\n" +
                "Hang san xuat: " + manufacturer + "\n" +
                "Mau: " + color + "\n" +
                "Nam san xuat: " + year + "\n" +
                "Gia ban: " + price +
                "So cho ngoi: " + seats + "\n" +
                "Dong co: " + engine ;
    }
}