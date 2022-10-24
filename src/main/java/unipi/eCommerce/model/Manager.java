package unipi.eCommerce.model;

import java.util.Date;

public class Manager extends  RegisteredUser{
    private Date hiredDate;
    private String title;

    public Manager(String firstName, String lastName, String username, String profilePicURL, boolean active, long createdDate, long updatedDate, Date hiredDate, String title) {
        super(firstName, lastName, username, profilePicURL, active, createdDate, updatedDate);
        this.hiredDate = hiredDate;
        this.title = title;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
