package unipi.eCommerce.base;

public class UserDAO {
    private static String query = "SELECT id, firstName, lastName, username, password,profilePicUrl,active, createdDate,updatedDate FROM RegisteredUser WHERE username = ?";
}
