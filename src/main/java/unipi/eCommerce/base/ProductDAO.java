package unipi.eCommerce.base;

import unipi.eCommerce.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends ConnectionFactory {
    private static int productsPerPage = 20;
    private static String query = "SELECT name, shortDescription, description, brand, imageUrl, price, stock FROM Product LIMIT ? OFFSET ?";

    public List<Product> listProducts(int page) throws SQLException
    {
        if(page <= 0)
            throw new RuntimeException("page > 0 grullo");

        try (Connection connection = super.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productsPerPage);
            preparedStatement.setInt(2, productsPerPage*page);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>(productsPerPage);
            while(resultSet.next())
            {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setShortDescription(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setBrand(resultSet.getString(4));
                product.setImageUrl(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setStock(resultSet.getInt(7));

                products.add(product);
            }
            return products;
        }
    }
}
