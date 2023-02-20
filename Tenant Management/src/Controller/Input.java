package Controller;

import Model.*;

import java.util.*;

public class Input {
    public Customer addCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter type of customer (family, student, Enterprise): ");
        String typeOfCustomer = scanner.nextLine();
        while (!Util.checkCustomerType(typeOfCustomer)) {
            System.out.println("Customer type is invalid. Please enter again: ");
            typeOfCustomer = scanner.nextLine();
        }
        return new Customer(Util.normalizeName(name), address, phoneNumber, typeOfCustomer);
    }
    public Order addOrder(Customer customer, List<Room>roomList){
        System.out.println("Enter room type customer want: ");
        String roomType = chooseTypeRoom();
        System.out.println("List room is empty: ");
        roomList.stream().filter(o -> o.isEmpty() == true && o.getTypeRoom().equalsIgnoreCase(roomType)).
                forEach(o -> System.out.println(o));
        System.out.println("Enter room id customer want: ");
        String idRoom = chooseIdRoom();
        Room room = roomList.stream().filter(o -> o.getIdRoom().equalsIgnoreCase(idRoom)).findFirst().orElse(null);
        room.setEmpty(false);
        return new Order(customer, room);
    }
    public Room addRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room name: ");
        String roomName = scanner.nextLine();
        System.out.println("Enter room type (Vip, normal, High quality): ");
        String roomType = chooseTypeRoom();
        return new Room(Util.normalizeName(roomName),roomType);
    }
    public void sortOrderByName(List<Order> orderList){
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getCustomer().getNameCustomer().compareTo(o2.getCustomer().getNameCustomer());
            }
        });
    }
    public void sortOrderByDate(List<Order>orderList){
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getDateCheckIn().compareTo(o2.getDateCheckIn());
            }
        });
    }
    public int choiceInteger(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    public String chooseTypeRoom(){
        Scanner scanner = new Scanner(System.in);
        String roomType = scanner.nextLine();
        while(!Util.checkRoomType(roomType)){
            System.out.println("Room type is invalid. Please enter again: ");
            roomType = scanner.nextLine();
        }
        return roomType;
    }
    public String chooseIdRoom(){
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }
}
