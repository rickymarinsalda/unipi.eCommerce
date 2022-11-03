package unipi.eCommerce.dto;

import unipi.eCommerce.model.Product;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCartDTO {
    public static class Item {
        int quantity;
        double totalPrice;
        String productName;

        public Item(int quantity, Product product) {
            this.quantity = quantity;
            this.totalPrice = product.getPrice() * quantity;
            this.productName = product.getName();
        }
    }

    long lastUpdate;
    List<Item> itemList;

    public void addProduct(Product product, int quantity)
    {
        if(itemList == null)
            itemList = new LinkedList<>();

        for(Item item: itemList) {
            if (item.productName.equals(product.getName())) {
                item.quantity += quantity;
                item.totalPrice += product.getPrice() * quantity;
                return;
            }
        }

        itemList.add(new Item(quantity, product));
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
