package unipi.eCommerce.base;

import unipi.eCommerce.model.RegisteredUser;

public class UserDAO {
    // id, firstName, lastName, username, password,profilePicUrl,active, createdDate,updatedDate
    private static final String query = "INSERT INTO RegisteredUser(id, firstName, lastName, username, password,profilePicUrl,active, createdDate,updatedDate)VALUES(?,?,?,?,?,?,?,?,?)";

    public void insertUser(RegisteredUser registeredUser){

    }
}
