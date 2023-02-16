import java.util.Scanner;

public class motorBike extends Vehicle{
    private  int power;

    public motorBike(String ID, String manufacturer, String color, String year, int price, int power) {
        super(ID, manufacturer, color, year, price);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\n" +
                "Hang san xuat: " + manufacturer + "\n" +
                "Mau: " + color + "\n" +
                "Nam san xuat: " + year + "\n" +
                "Gia ban: " + price +
                "Cong xuat: " + power ;
    }
}