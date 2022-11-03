package unipi.eCommerce.base;

import redis.clients.jedis.Jedis;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String MYSQL_HOST = "localhost";
    private static final Integer MYSQL_PORT = 3306;
    private static final String MYSQL_DATABASE = "eCommerce";
    private static final String MYSQL_USERNAME = "ricky";
    private static final String MYSQL_PASSWORD = "root";

    private static final String JDBC_URL = "jdbc:mysql://%s:%s@%s:%d/%s";

    public java.sql.Connection getConnection() throws SQLException{
        String jdbcUrl = String.format(JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD, MYSQL_HOST, MYSQL_PORT, MYSQL_DATABASE);

        Properties properties = new Properties();
        properties.put("zeroDateTimeBehavior", "CONVERT_TO_NULL");
        properties.put("serverTimeZone","CET");
        return DriverManager.getConnection(jdbcUrl, properties);
    }

    private static final String JEDIS_URL = "localhost";
    private static final int JEDIS_PORT = 6379;

    public Jedis getJedisConnection()
    {
        return new Jedis(JEDIS_URL, JEDIS_PORT);
    }
}
