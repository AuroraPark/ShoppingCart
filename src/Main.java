//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

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



public class Main {
    public static void main(String[] args) {

    }
}