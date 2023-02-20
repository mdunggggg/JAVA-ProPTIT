package Controller;
import Model.*;

import java.util.List;

public class Output {
    public void showMenu(){
        System.out.println("1. Add customer");
        System.out.println("2. Add room");
        System.out.println("3. Show customer");
        System.out.println("4. Show room by type");
        System.out.println("5. Show order");
        System.out.println("6. Sort customer by name");
        System.out.println("7. Sort customer by date check in");
        System.out.println("8. Exit");
    }
    public void showListCustomer(List<Customer> customerList){
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
    public void showListRoomByType(String type, List<Room> roomList){
        roomList.stream().filter(o -> o.isEmpty() == true && o.getTypeRoom().equalsIgnoreCase(type)).
                forEach(o -> System.out.println(o));
    }
    public void statisticsOrder(List<Order> orderList){
        System.out.println("Total order: " + orderList.size());
        System.out.println("Total order VIP: " + orderList.stream().filter(o -> o.getRoom().
                getTypeRoom().
                equalsIgnoreCase("VIP")).count());
        System.out.println("Total order High Quality: " + orderList.stream().filter(o -> o.getRoom().
                getTypeRoom().
                equalsIgnoreCase("High Quality")).count());
        System.out.println("Total order Normal: " + orderList.stream().filter(o -> o.getRoom().
                getTypeRoom().
                equalsIgnoreCase("Normal")).count());
    }
    public void showMessage(String message){
        System.out.println(message);
    }
}
