public class Lecturers {
    protected String ID, name, email, hocham, hocvi, address, phone;
    protected int workingHour;
    protected float hesoluong;
    protected double salary;
    Lecturers(){
    }
    Lecturers(String ID,String name,String email, String hocham, String hocvi, String address, String phone, int workingHour, float hesoluong){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.hocham = hocham;
        this.hocvi = hocvi;
        this.address = address;
        this.phone = phone;
        this.workingHour = workingHour;
        this.hesoluong = hesoluong;
    }
    public void showInfor(){
        System.out.println("ID: " + this.ID);
        System.out.println("Ten: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Hoc ham: " + this.hocham);
        System.out.println("Hoc vi: " + this.hocvi);
        System.out.println("Dia chi: " + this.address);
        System.out.println("Phone: " + this.phone);
        System.out.println("So gio lam viec: " + this.workingHour);
        System.out.println("He so luong: " + this.hesoluong);
        System.out.println("Tổng lương: " + this.salary);
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }

}
