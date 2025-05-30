package carstore;

public class ProfileData {
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private int ID;

    public ProfileData(String name, String address, String contactNumber, String email, int ID) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getID() {
        return ID;
    }

}