import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true){
            Menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                String ID, manufacturer, color, year;
                int price;
                System.out.println("1. Oto   2. Xe may   3.  Xe tai");
                int choicee = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhap ID: ");
                ID = scanner.nextLine();
                System.out.println("Nhap hang xan xuat: ");
                manufacturer = scanner.nextLine();
                System.out.println("Nhap mau sac: ");
                color = scanner.nextLine();
                System.out.println("Nam san xuat: ");
                year = scanner.nextLine();
                System.out.println("Nhap gia ban: ");
                price = scanner.nextInt();
                scanner.nextLine();
                if(choicee == 1){
                    int seats;
                    String engine;
                    System.out.println("Nhap so cho ngoi: ");
                    seats = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhap dong co: ");
                    engine = scanner.nextLine();
                    manager.addVehicle(new Car(ID, manufacturer,color, year, price , seats, engine));
                }
                else if(choicee == 2){
                    int power;
                    System.out.println("Nhap cong suat: ");
                    power = scanner.nextInt();
                    scanner.nextLine();
                    manager.addVehicle(new motorBike(ID, manufacturer, color, year, price, power));
                }
                else{
                    System.out.println("Nhap tai trong: ");
                    int payLoad = scanner.nextInt();
                    scanner.nextLine();
                    manager.addVehicle(new Truck(ID, manufacturer, color, year, price, payLoad));
                }
            }
            else if(choice == 2){
                manager.showInfor();
            }
            else if(choice == 3){
                System.out.println("1.ID   2. Hang SX   3. Nam SX  4.Mau sac   5.Cho ngoi");
                int type = scanner.nextInt();
                scanner.nextLine();
                if(type == 1){
                    System.out.println("Nhap ID: ");
                    String ID = scanner.nextLine();
                    manager.findVehicleById(ID);
                }
                else if(type == 2){
                    System.out.println("Nhap hang san xuat: ");
                    String hsx = scanner.nextLine();
                    manager.findVehicleByManufacturer(hsx);
                }
                else if(type == 3){
                    System.out.println("Nhap nam: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    manager.findVehicleByYear(year);
                }
                else if(type == 4){
                    System.out.println("Nhap mau sac: ");
                    String color = scanner.nextLine();
                    manager.findVehicleByColor(color);
                }
                else {
                    System.out.println("Nhap cho ngoi: ");
                    int seats = scanner.nextInt();
                    scanner.nextLine();
                    manager.findVehicleBySeats(seats);
                }
            }
            else if(choice == 4){
                System.out.println("1.Nam     2.Gia");;
                int type = scanner.nextInt();
                scanner.nextLine();
                if(type == 1){
                    System.out.println("Nhap nam bat dau va ket thuc");
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    scanner.nextLine();
                    manager.findVehicleByYear(start, end);
                }
                else{
                    System.out.println("Nhap gia cao nhat va thap nhat: ");
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    scanner.nextLine();
                    manager.findVehicleByPrice(start, end);
                }
            }
            else if(choice == 5){

            }
            else if(choice == 6){
                System.out.println("1. Gia ban    2.Hang    3.Nam");
                int type = scanner.nextInt();
                scanner.nextLine();
                if(type == 1){
                    manager.sortVehicleByPrice();
                }
                else if(type == 2){
                    manager.sortVehicleByMana();
                }
                else
                    manager.sortVehicleByYear();
            }
        }
    }
    public static void Menu(){
        System.out.println("*_____MENU______*");
        System.out.println("1.Th??m ph????ng ti???n.");
        System.out.println("2.In danh s??ch ph????ng ti???n.");
        System.out.println("3.T??m ph????ng ti???n.");
        System.out.println("4.T??m theo kho???ng (n??m/gi?? b??n).");
        System.out.println("5.T??m ...");
        System.out.println("6.S???p x???p danh s??ch(theo gi?? b??n,n??m,h??ng).");
        System.out.println("7.Th???ng k??.");
        System.out.println("0.Tho??t.");
        System.out.print("M???i b???n ch???n:");
    }

}