package domain;

public class Customer {
    private String address;

    public Customer(String address) {
        this.address = address;
    }

    private String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }
}
