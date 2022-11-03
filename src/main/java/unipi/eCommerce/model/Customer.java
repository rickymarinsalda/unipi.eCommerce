package unipi.eCommerce.model;

public class Customer extends RegisteredUser{
    private String address;
    private String country;
    private String phone;

    public Customer(String firstName, String lastName, String username, String profilePicURL, boolean active, long createdDate, long updatedDate, String password, String address, String country, String phone) {
        super(firstName, lastName, username, profilePicURL, active, createdDate, updatedDate, password);
        this.address = address;
        this.country = country;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
