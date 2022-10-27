package unipi.eCommerce;

import unipi.eCommerce.base.ProductDAO;
import unipi.eCommerce.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        ProductDAO pdao = new ProductDAO();

        // Testmaxxer
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("Insert page number: ");
            System.out.flush();
            int page = sc.nextInt();
            List<Product> products = pdao.listProducts(page);

            products.forEach(product -> {
                System.out.println(product.getName());
            });
        }
    }
}
