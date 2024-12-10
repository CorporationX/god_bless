package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductsSystem productsSystem = new ProductsSystem();
        productsSystem.addItem("apple", "fruits");
        productsSystem.addItem("banana", "fruits");
        productsSystem.addItem("orange", "fruits");
        productsSystem.addItem("grapes", "fruits");
        productsSystem.addItem("horse", "meats");
        productsSystem.addItem("beef", "meats");
        productsSystem.addItem("chicken", "meats");
        productsSystem.addItem("olivier", "salad");
        productsSystem.addItem("vinegret", "salad");
        productsSystem.addItem("mimosa", "salad");

        System.out.println("Print all products");
        printProductsByCategory(groupProductsByCategory(productsSystem.products));
        System.out.println("Print products within meats category");
        printProductsByCategory(groupProductsByCategory(productsSystem.findItemsByCategory("meats")));
        System.out.println("Remove product from productsSystem");
        productsSystem.removeItem("apple", "fruits");
        printProductsByCategory(groupProductsByCategory(productsSystem.findItemsByCategory("fruits")));
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product item : products) {
            String category = item.getCategory();
            if (groupedProducts.containsKey(category)) {
                List<Product> list = groupedProducts.get(category);
                list.add(item);
            } else {
                List<Product> list = new ArrayList<>();
                list.add(item);
                groupedProducts.put(category, list);
            }
        }
        return groupedProducts;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry);
        }
    }
}
