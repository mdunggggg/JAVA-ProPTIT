package Model;

public class Staff extends Person {
    private String staffType;

    public Staff(String id, String address, String name, String phoneNumber, String staffType) {
        super(id, address, name, phoneNumber);
        this.staffType = staffType;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t" +
                "Name: " + name + "\t" +
                "Address: " + address + "\t" +
                "Phone: " + phoneNumber + "\t" +
                "Type staff: " + staffType ;
    }
}
