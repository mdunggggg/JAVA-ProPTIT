import java.util.*;

public class Manager {
    private List<Vehicle> vehicleList;
    public Manager(){
        vehicleList = new ArrayList<>();
    }
    void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
    void showInfor(){
        vehicleList.forEach(o -> System.out.println(o));
    }
    void findVehicleById(String ID){
        vehicleList.stream().filter(o -> o.getID().contains(ID))
                .forEach(o -> System.out.println(o));
        System.out.println("Tong so phuong tien: " + vehicleList.size());
    }
    void findVehicleByManufacturer(String manufacturar){
        vehicleList.stream().filter(o -> o.getID().contains(manufacturar))
                .forEach(o -> System.out.println(o));
    }
    void findVehicleByPrice(int price){
        vehicleList.stream().filter(o -> o.getPrice() == price)
                .forEach(o -> System.out.println(o));
    }
    void findVehicleByYear(int year){
        vehicleList.stream().filter(o -> Integer.parseInt(o.getYear()) == year)
                .forEach(o -> System.out.println(o));
    }
    void findVehicleByPrice(int start, int end){
        vehicleList.stream().filter(o -> o.getPrice() <= end && o.getPrice() >= start)
                .forEach(o -> System.out.println(o));
    }
    void findVehicleByColor(String color){
        vehicleList.stream().filter(o -> o.getID().contains(color))
                .forEach(o -> System.out.println(o));
    }
    void findVehicleBySeats(int seat){
        vehicleList.stream().filter(o -> o.getPrice() == seat)
                .forEach(o -> System.out.println(o));
    }
    void findVehicleByYear(int start, int end){
        vehicleList.stream().filter(o -> Integer.parseInt(o.getYear()) >= start && Integer.parseInt(o.getYear()) <= end)
                .forEach(o -> System.out.println(o));
    }
    void sortVehicleByPrice(){
        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                if(o1.getPrice() == o2.getPrice())
                    return 0;
                else if(o1.getPrice() < o2.getPrice()){
                    return 1;
                }
                return -1;
            }
        });
    }
    void sortVehicleByYear(){
        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getYear().compareTo(o2.getYear());
            }
        });
    }
    void sortVehicleByMana(){
        Collections.sort(vehicleList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getManufacturer().compareTo(o2.getManufacturer());
            }
        });
    }


}