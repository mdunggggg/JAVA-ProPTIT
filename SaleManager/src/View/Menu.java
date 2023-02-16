package View;

import Model.Customer;
import Model.Item;
import Model.Order;
import Model.Staff;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    public Scanner scanner = new Scanner(System.in);
    public static <T> void writeToFile(T t, String path){
        try{
            FileWriter fw = new FileWriter("src\\Controller\\" + path + ".DAT", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(t.toString());
            bw.newLine();
            bw.close();
            fw.close();
        }
        catch (Exception e){

        }
    }
    public static <T> void writeToFile(List<T>list, String path){
        try{
            FileWriter fw = new FileWriter("src\\Controller\\" + path + ".DAT");
            BufferedWriter bw = new BufferedWriter(fw);
            for(T t : list){
                bw.write(t.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch(Exception e){

        }
    }
    public static <T> void deleteFile(String path){
        try{
            FileWriter fw = new FileWriter("src\\Controller\\" + path + ".DAT");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
            fw.close();
        }
        catch (Exception e){

        }

    }

    public static void main(String[] args) {
            Menu menu = new Menu();
            List<Customer>customerList = new ArrayList<>();
            List<Staff>staffList = new ArrayList<>();
            List<Item>itemList = new ArrayList<>();
            List<Order>orderList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            int choice;
            while(true){
                menu.showMenu();
                choice = scanner.nextInt();
                scanner.nextLine();
                if(choice == 1){
                    staffList.add(menu.addStaff());
                }
                else if(choice == 2){
                    customerList.add(menu.addCustomer());
                }
                else if(choice == 3){
                    itemList.add(menu.addItem());
                }
                else if(choice == 4){
                    orderList.add(menu.addOrder());
                }
                else if(choice == 5){
                    menu.sortOrderByIdStaff(orderList);
                }
                else if(choice == 6){
                    menu.sortOrderByTime(orderList);
                }
                else if(choice == 7){
                    menu.sortOrderByNameCustomer(orderList, customerList);
                }
                else if(choice == 8){
                    menu.calcSalary(orderList, itemList);
                }
                else if(choice == 9){
                    menu.showInfor(orderList);
                    menu.showInfor(staffList);
                    menu.showInfor(customerList);
                    menu.showInfor(itemList);
                }
                else if(choice == 10){
                    deleteFile("MH");
                    deleteFile("KH");
                    deleteFile("NV");
                    deleteFile("DH");
                }
                else if(choice == 0){
                    System.out.println("BYE!!!");
                    return;
                }
            }

    }
    public void showMenu(){
        System.out.println("1. Add staff" + "\n" +
                "2. Add customer"  + "\n" +
                "3. Add item"  + "\n" +
                "4. Add order"  + "\n" +
                "5. Sort orders by id staff" + "\n" +
                "6. Sort orders by time " + "\n" +
                "7. Sort orders by customer"  + "\n" +
                "8. Calculator salary"  + "\n" +
                "9. Show information"  + "\n" +
                "10.Clear data"  + "\n" +
                "0. Exit.");
    }
    public Staff addStaff(){
        String id;
        String address;
        String name;
        String phoneNumber;
        String staffType;
        System.out.println("Nhap ID (PT-XXX, FT-XXX): ");
        id = scanner.nextLine();
        while(checkIdStaff(id) == false){
            System.out.println("Nhap sai dinh dang. Moi nhap lai: ");
            id = scanner.nextLine();
        }
        System.out.println("Nhap ten: ");
        name = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        address = scanner.nextLine();
        System.out.println("Nhap so dien thoai: ");
        phoneNumber = scanner.nextLine();
        if(id.substring(0, 3).equals("FT"))
            staffType = "Full time";
        else
            staffType = "Part time";
        Staff staff =  new Staff(id, address, name, phoneNumber, staffType);
        writeToFile(staff, "NV");
        return staff;
    }
    public Customer addCustomer(){
        String id;
        String address;
        String name;
        String phoneNumber;
        String gmail;
        System.out.println("Nhap ID: ");
        id = scanner.nextLine();
        System.out.println("Nhap ten: ");
        name = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        address = scanner.nextLine();
        System.out.println("Nhap so dien thoai: ");
        phoneNumber = scanner.nextLine();
        System.out.println("Nhap gmail: ");
        gmail = scanner.nextLine();
        Customer customer = new Customer(id, address, name, phoneNumber, gmail);
        writeToFile(customer, "KH");
        return customer;
    }
    public Item addItem(){
        String id;
        String name;
        String itemType;
        int price;
        System.out.println("Nhap ID: ");
        id = scanner.nextLine();
        System.out.println("Nhap ten: ");
        name = scanner.nextLine();
        System.out.println("Nhap nhom hang: ");
        itemType = scanner.nextLine();
        System.out.println("Nhap gia: ");
        price = scanner.nextInt();
        scanner.nextLine();
        Item item = new Item(id, name, itemType, price);
        writeToFile(item , "MH");
        return item;
    }
    public Order addOrder(){
        String id_Item;
        String id_Customer;
        String id_Staff;
        int number;
        System.out.println("Nhap id cua mat hang: ");
        id_Item = scanner.nextLine();
        System.out.println("Nhap id cua khach hang: ");
        id_Customer = scanner.nextLine();
        System.out.println("Nhap id cua nhan vien: ");
        id_Staff = scanner.nextLine();
        System.out.println("Nhap so luong don hang: ");
        number = scanner.nextInt();
        scanner.nextLine();
        Order order = new Order(id_Item, id_Customer, id_Staff, number);
        writeToFile(order, "DH");
        return order;
    }
    public void sortOrderByIdStaff(List<Order>list){
        Collections.sort(list, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getId_Staff().compareTo(o2.getId_Staff());
            }
        });
        writeToFile(list, "DH");
    }
    public void sortOrderByNameCustomer(List<Order>list, List<Customer>listCus){

        Collections.sort(list, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                String o1_name = listCus.stream().filter(o -> o.getId().equals(o1.getId())).findFirst().orElse(null).getName();
                String o2_name = listCus.stream().filter(o -> o.getId().equals(o2.getId())).findFirst().orElse(null).getName();
                if(o1_name.equals(o2_name)){
                    return o1.getId().compareTo(o2.getId());
                }
                else
                    return o1_name.compareTo(o2_name);
            }
        });

        writeToFile(list, "DH");
    }
    public void sortOrderByTime(List<Order>list){
        Collections.sort(list, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getTimeCreated().compareTo(o2.getTimeCreated());
            }
        });
        writeToFile(list, "DH");
    }

    public double calcSalary(List<Order>list, List<Item>listItem){
        System.out.println("Nhap id nhan vien: ");
        String id_Staff = scanner.nextLine();
        List<Order>listOrderCurrent = list.stream().filter(o -> o.getId_Staff().equals(id_Staff)).collect(Collectors.toList());
        double price = 0;
        for(Order order : listOrderCurrent){
            String id_Item = order.getId_Item();
            int number = order.getNumber();
            for(Item item : listItem){
                if(item.getId().equals(id_Item)){
                    price += (double)number * item.getPrice();
                    break;
                }
            }
        }
        if(id_Staff.substring(0, 3).equals("PT")) return price * 0.05;
        else return price * 1.0;
    }
    public <T> void showInfor(List<T>list){
        if(list.size() >= 1){
            System.out.println("\t\tLIST OF:  " + list.get(0).getClass().getSimpleName() + "\t\t");
            list.forEach(o -> System.out.println(o));
        }
    }
    public boolean checkIdStaff(String id){
        return id.matches("^[PF]T[0-9]{3}$");
    }
}