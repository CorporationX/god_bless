package faang.school.godbless.BJS219343;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Монитор", "Компьютерная техника"));
        products.add(new Product(2, "Процессор", "Компьютерная техника"));
        products.add(new Product(3, "Видеокарта", "Компьютерная техника"));
        products.add(new Product(4, "Стиральная машина", "Бытовая техника"));
        products.add(new Product(5, "Холодильник", "Бытовая техника"));
        products.add(new Product(6, "Телевизор", "Бытовая техника"));
        products.add(new Product(7, "Костюм", "Одежда"));

        showProductsByCategory(productsByCategory(products));

    }

    public static Map<String, List<Product>> productsByCategory(Set<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            if (productsByCategory.containsKey(product.getCategory())) {
                productsByCategory.get(product.getCategory()).add(product);
            } else {
                List<Product> productList = new ArrayList<>();
                productList.add(product);
                productsByCategory.put(product.getCategory(), productList);
            }
        }
        return productsByCategory;
    }

    public static void showProductsByCategory(Map<String, List<Product>> productsByCategory) {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
