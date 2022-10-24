package unipi.eCommerce.model;

public class RegisteredUser {
    private String firstName;
    private String lastName;
    private String username;
    private String profilePicURL;
    private boolean active;
    private long createdDate;
    private long updatedDate;

    public RegisteredUser() {};

    public RegisteredUser(String firstName, String lastName, String username, String profilePicURL, boolean active, long createdDate, long updatedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.profilePicURL = profilePicURL;
        this.active = active;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(long updatedDate) {
        this.updatedDate = updatedDate;
    }
}
