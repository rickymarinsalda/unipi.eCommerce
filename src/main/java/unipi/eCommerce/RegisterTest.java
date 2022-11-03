package unipi.eCommerce;

import unipi.eCommerce.base.UserDAO;
import unipi.eCommerce.model.Customer;
import unipi.eCommerce.model.RegisteredUser;

import java.sql.SQLException;
import java.util.Scanner;

public class RegisterTest {
    public static void main(String[] args) throws SQLException {
        Customer ru = new Customer(
                "Mario", "Rossi", "mario64", "", true, System.currentTimeMillis() / 1000, 0, "password1234325234",
                "Via Diotisalvi 1", "Italy", "+39 050 55555"
        );

        UserDAO userDAO = new UserDAO();
        userDAO.registerCustomer(ru);


    }
}
