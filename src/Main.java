//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        // DONE: csv 파일에서 상품 목록 가져오기
        String csvFile = "src/product.csv";
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                if(values.length == 3){
                    String key = values[0].trim();
                    String name = values[1].trim();
                    int price = Integer.parseInt(values[2].trim());
                    productSet.add(new Product(key, name, price));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("CSV 파일로부터 불러온 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : $" + product.getPrice());
        }
        // DONE: 상품 클래스를 생성하여 상품 목록에 넣는다.
       //  productSet.add(new Product("milk", "우유", 2000));
       //  productSet.add(new Product("apple", "사과", 1000));

        Product milk = new Product("milk", "우유", 2000);
        Product apple = new Product("apple", "사과", 1000);

        // 상품 목록 확인
        System.out.println("고유한 상품 목록: ");
        for(Product product : productSet){
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        ShoppingCart myCart = new ShoppingCart();

        // DONE: 상품을 장바구니에 추가
        myCart.addProduct(milk, 2); // 우유 2개 추가
        myCart.addProduct(apple, 1); // 사과 1개 추가
        // DONE: 상품을 장바구니에서 제거
        myCart.removeProduct(milk, 1); // 우유 1개 제거

        // DONE: 장바구니에 현재 담긴 상품들을 출력(상품 이름, 각 상품의 갯수)
        myCart.showItems();
    }
}