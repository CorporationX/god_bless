package faang.school.godbless.Mathw;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class Main {
    public static final Set<Product> productSet = new HashSet<>();

    public static HashMap<String, List<Product>> groupByCategories(Set<Product> productSet) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : productSet) {
            String category = product.getCategory();
            groupedProducts.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
        }

        return groupedProducts;
    }

    public static void getAllCategoryProducts(HashMap<String, List<Product>> mappa) {
        for (Map.Entry<String, List<Product>> entry : mappa.entrySet()) {
            System.out.println("Key:" + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("Value:" + product.getId() + " " + product.getName());
            }
        }
    }

    public static void main(String[] args) {
        productSet.add(new Product(1, "Milk", "Milk Products"));
        productSet.add(new Product(2, "Bread", "Bakery Products"));
        productSet.add(new Product(3, "Apple", "Fruits"));
        productSet.add(new Product(4, "Orange Juice", "Beverages"));
        productSet.add(new Product(5, "T-shirt", "Clothing"));
        productSet.add(new Product(6, "Socks", "Clothing"));
        productSet.add(new Product(7, "Headphones", "Electronics"));
        productSet.add(new Product(8, "Laptop", "Electronics"));
        productSet.add(new Product(9, "Desk Lamp", "Home Appliances"));
        productSet.add(new Product(10, "Toothbrush", "Personal Care"));


        getAllCategoryProducts(groupByCategories(productSet));
    }
}