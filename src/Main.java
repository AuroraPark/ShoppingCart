//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Product {
    private String key;
    private String name;
    private int price;

    public Product(String key, String name, int price){
        this.key = key;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return key.equals(product.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }

    // Getters
    public String getKey(){
        return key;
    }

    public String getName(){
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart(){
        items = new HashMap<>();
    }

    // addProduct()
    public void addProduct(Product product, int quantity){
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    // removeProduct()
    public void removeProduct(Product product, int quantity){
        int currentQuantity = items.getOrDefault(product, 0);
        if(currentQuantity <= quantity){
            items.remove(product);
        } else {
          items.put(product, currentQuantity - quantity);
        }
    }

    // showItems()
    public void showItems() {
        if(items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        System.out.println("장바구니 내용: ");
        for(Map.Entry<Product, Integer> entry : items.entrySet()){
            System.out.println(entry.getKey() + ", 수량: " + entry.getValue());
        }
    }
}


public class Main {
    public static void main(String[] args) {

    }
}