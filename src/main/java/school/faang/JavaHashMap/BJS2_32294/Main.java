package school.faang.JavaHashMap.BJS2_32294;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static Set<Product> products = new HashSet<>();
    static Map<String, List<Product>> groupedProducts;

    public static void main(String[] args) {
        products.add(new Product(1, "Tomato", "Vegetables"));
        products.add(new Product(2, "Cucumber", "Vegetables"));
        products.add(new Product(3, "Carrot", "Vegetables"));
        products.add(new Product(4, "Broccoli", "Vegetables"));
        products.add(new Product(5, "Spinach", "Vegetables"));
        products.add(new Product(6, "Apple", "Fruits"));
        products.add(new Product(7, "Banana", "Fruits"));
        products.add(new Product(8, "Orange", "Fruits"));
        products.add(new Product(9, "Grape", "Fruits"));
        products.add(new Product(10, "Pineapple", "Fruits"));
        products.add(new Product(11, "Milk", "Dairy"));
        products.add(new Product(12, "Cheese", "Dairy"));
        products.add(new Product(13, "Yogurt", "Dairy"));
        products.add(new Product(14, "Butter", "Dairy"));
        products.add(new Product(15, "Cream", "Dairy"));
        products.add(new Product(16, "Bread", "Bakery"));
        products.add(new Product(17, "Croissant", "Bakery"));
        products.add(new Product(18, "Muffin", "Bakery"));
        products.add(new Product(19, "Cake", "Bakery"));
        products.add(new Product(20, "Bagel", "Bakery"));

        groupedProducts = productGrouping(products);

        outputOfAllGroupedProducts();
    }

    public static Map<String, List<Product>> productGrouping(Set<Product> products) {
        Map<String, List<Product>> groupingProducts = new HashMap<>();
        for (Product product : products) {
            groupingProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupingProducts;
    }

    public static void outputOfAllGroupedProducts(){
        for(Map.Entry<String, List<Product>> category : groupedProducts.entrySet()){
            System.out.println("Категория товара: " + category.getKey());
            System.out.println("Список товаров:");
            for (Product product : category.getValue()){
                System.out.println(product);
            }
            System.out.println();
        }
    }
}
