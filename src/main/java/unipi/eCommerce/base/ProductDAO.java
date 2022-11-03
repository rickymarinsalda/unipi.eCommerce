package unipi.eCommerce.base;

import unipi.eCommerce.model.Beer;
import unipi.eCommerce.model.Book;
import unipi.eCommerce.model.Monitor;
import unipi.eCommerce.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends ConnectionFactory {
    private static final int productsPerPage = 2;
    private static final String query = "SELECT name, shortDescription, description, brand, imageUrl, price, stock, class, ingredients, alcoholPercentage, liquidVolumeInML, liquidVolumeInML, summary, `language`, numberPages, screenSizeInches, displayResolutionX, displayResolutionY, specialFeatures, refreshRateHz FROM Product LIMIT ? OFFSET ?";
    private static final String query2 = "SELECT name, shortDescription, description, brand, imageUrl, price, stock, class, ingredients, alcoholPercentage, liquidVolumeInML, liquidVolumeInML, summary, `language`, numberPages, screenSizeInches, displayResolutionX, displayResolutionY, specialFeatures, refreshRateHz FROM Product WHERE name = ?";

    private static Product createFromTuple(ResultSet resultSet) throws SQLException
    {
        // class, ingredients, alcoholPercentage, liquidVolumeInML,
        // liquidVolumeInML, summary, language, numberPages, screenSizeInches,
        // displayResolutionX, displayResolutionY, specialFeatures, refreshRateHz
        Product product;
        if (resultSet.getString(8).equals("Beer")) {
            Beer beer = new Beer();
            product = beer;

            // beer.setIngredients(); @TODO RICKY MESSED UP
            beer.setAlcholPercentage(resultSet.getDouble(10));
            beer.setLiquidVolumeInML(resultSet.getDouble((11)));
        }
        else if (resultSet.getString(8).equals("Book")) {
            Book book = new Book();
            product = book;

            book.setSummary(resultSet.getString(13));
            book.setLanguage(resultSet.getString(14));
            book.setNumberOfPages(resultSet.getInt(15));
        }
        else if (resultSet.getString(8).equals("Monitor")) {
            Monitor monitor = new Monitor();
            product = monitor;

            monitor.setScreenSizeInches(resultSet.getDouble(15));
            monitor.setDisplayResolution(new int[]{
                    resultSet.getInt(17),
                    resultSet.getInt(18)
                    });
            //monitor.setSpecialFeatures(); // @TODO
            monitor.setRefreshRateHz(resultSet.getDouble(20));
        }
        else throw new RuntimeException("Unknow prodact");

        product.setName(resultSet.getString(1));
        product.setShortDescription(resultSet.getString(2));
        product.setDescription(resultSet.getString(3));
        product.setBrand(resultSet.getString(4));
        product.setImageUrl(resultSet.getString(5));
        product.setPrice(resultSet.getDouble(6));
        product.setStock(resultSet.getInt(7));

        return product;
    }

    public List<Product> listProducts(int page) throws SQLException
    {
        if(page <= 0)
            throw new RuntimeException("page > 0 grullo");

        page--;

        try (Connection connection = super.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productsPerPage);
            preparedStatement.setInt(2, productsPerPage*page);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>(productsPerPage);
            while(resultSet.next())
                products.add(createFromTuple(resultSet));

            return products;
        }
    }

    public Product getProduct(String nomeProdotto) throws SQLException
    {
        try (Connection connection = super.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setString(1,nomeProdotto);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst())
                return null;

            resultSet.next();
            return createFromTuple(resultSet);
        }
    }

}
