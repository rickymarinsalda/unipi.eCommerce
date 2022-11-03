package unipi.eCommerce.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import redis.clients.jedis.Jedis;
import unipi.eCommerce.dto.ShoppingCartDTO;
import unipi.eCommerce.model.Customer;
import unipi.eCommerce.model.Product;
import unipi.eCommerce.model.ShoppingCart;

public class ShoppingCartDAO extends ConnectionFactory {
    public void addToCart(Customer customer, Product product, int quanity) // Oppure Product product???
    {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try(Jedis jd = super.getJedisConnection())
        {
            final String key = "eCommerce:" + customer.getUsername() + ":cart";
            ShoppingCartDTO shoppingCartDTO;

            if(jd.exists(key))
                shoppingCartDTO = gson.fromJson(jd.get(key), ShoppingCartDTO.class);
            else
                shoppingCartDTO = new ShoppingCartDTO();

            shoppingCartDTO.setLastUpdate(System.currentTimeMillis() / 1000);
            shoppingCartDTO.addProduct(product, quanity);

            jd.set(key, gson.toJson(shoppingCartDTO));
        }
    }
}
