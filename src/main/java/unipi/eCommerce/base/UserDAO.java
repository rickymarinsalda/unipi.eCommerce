package unipi.eCommerce.base;

import unipi.eCommerce.model.Customer;
import unipi.eCommerce.model.RegisteredUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO extends ConnectionFactory {
    // id, firstName, lastName, username, password,profilePicUrl,active, createdDate,updatedDate
    private static final String query =
            "INSERT INTO RegisteredUser(firstName, lastName, username, password,profilePicUrl) " +
                    "VALUES(?,?,?,?,?)";

    private static final String query_customer = "INSERT INTO Customer(id, address, country, phone) VALUES(LAST_INSERT_ID(), ?, ?, ?)";

    public void registerCustomer(Customer customer) throws SQLException {
        try (Connection connection = super.getConnection()) {
            // Inizio transazione
            connection.setAutoCommit(false);

            PreparedStatement stm = connection.prepareStatement(query);

            stm.setString(1, customer.getFirstName());
            stm.setString(2, customer.getLastName());
            stm.setString(3, customer.getUsername());
            stm.setString(4, customer.getPassword());
            stm.setString(5, customer.getProfilePicURL());
            //stm.setBoolean(6, customer.isActive());
            // campi defualt fvaluie

            stm.executeUpdate();
            stm.close();

            stm = connection.prepareStatement(query_customer);

            stm.setString(1, customer.getAddress());
            stm.setString(2, customer.getCountry());
            stm.setString(3, customer.getPhone());

            stm.executeUpdate();
            stm.close();

            connection.commit();
        }
    }
}
