package Model;

import java.io.Serializable;

public class Customer implements Serializable {
    public static int NUM_CUSTOMER = 0;
    private String idCustomer;
    private String nameCustomer;
    private String addressCustomer;
    private String phoneCustomer;
    private String typeCustomer;

    public Customer(String nameCustomer, String addressCustomer, String phoneCustomer, String typeCustomer) {

        ++NUM_CUSTOMER;
        this.idCustomer = "0".repeat(5 - String.valueOf(NUM_CUSTOMER).length()) + NUM_CUSTOMER;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.phoneCustomer = phoneCustomer;
        this.typeCustomer = typeCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                ", phoneCustomer='" + phoneCustomer + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                '}';
    }
}
