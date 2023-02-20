package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    Input input = new Input();
    Output output = new Output();
    List<Customer>customerList = new ArrayList<>();
    List<Room>roomList = new ArrayList<>();
    List<Order>orderList = new ArrayList<>();
    public void run(){
        int choice;
        while(true) {
            output.showMenu();
            choice = input.choiceInteger();
            switch (choice){
                case 1:
                    Customer customer = input.addCustomer();
                    customerList.add(customer);
                    orderList.add(input.addOrder(customer, roomList));
                    break;
                case 2:
                    roomList.add(input.addRoom());
                    break;
                case 3:
                    output.showListCustomer(customerList);
                    break;
                case 4:
                    output.showListRoomByType(input.chooseTypeRoom(), roomList);
                    break;
                case 5:
                    output.statisticsOrder(orderList);
                    break;
                case 6:
                    input.sortOrderByName(orderList);
                    break;
                case 7:
                    input.sortOrderByDate(orderList);
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
