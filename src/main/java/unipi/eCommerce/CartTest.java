package unipi.eCommerce;

import unipi.eCommerce.base.ProductDAO;
import unipi.eCommerce.base.ShoppingCartDAO;
import unipi.eCommerce.model.Customer;
import unipi.eCommerce.model.Product;

import java.sql.SQLException;

public class CartTest {
    public static void main(String[] args) throws SQLException {
        Customer ru = new Customer(
                "Mario", "Rossi", "mario64", "", true, System.currentTimeMillis() / 1000, 0, "password1234325234",
                "Via Diotisalvi 1", "Italy", "+39 050 55555"
        );

        ProductDAO productDAO = new ProductDAO();
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();

        Product birra = productDAO.getProduct("Moretti 33cl");
        Product monitor = productDAO.getProduct("LG24XXDSFDSFIOEWURJOIDFJ");

        shoppingCartDAO.addToCart(ru, birra, 6);
        shoppingCartDAO.addToCart(ru, monitor, 1);
    }
}
