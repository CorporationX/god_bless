package school.faang.bjs245146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static HashSet<Product> products = new HashSet<>();

    private static void addItem(String name, String category) {
        products.add(new Product(name, category));
    }

    private static void removeItem(String name, String category) {
        Product product = new Product(name, category);
        if (!products.remove(product)) {
            System.out.println("This product is not available in our set");
        } else {
            System.out.println(product + " has been removed from set");
        }
    }

    private static void findItemsByCategory(String category) {
        List<Product> listProduct = new ArrayList<>();
        for (Product product : products) {
            if (Objects.equals(product.getCategory(), category)) {
                listProduct.add(product);
            }
        }
        if (!listProduct.isEmpty()) {
            System.out.println(listProduct);
        } else {
            System.out.println("This category is not available in our set");
        }
    }

    private static void printAllItems() {
        System.out.println(products);
    }

    private static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupProducts = new HashMap<>();
        for (Product product : products) {
            groupProducts.computeIfAbsent(product.getCategory(), category -> new ArrayList<>())
                    .add(product);
        }
        return groupProducts;
    }

    private static void printProductsByCategory(Map<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addItem("Milk", "Food");
        addItem("Iphone", "Household appliances");
        addItem("Soap", "Household chemicals");
        addItem("TV", "Household appliances");
        addItem("Apple", "Food");

        printAllItems();

        removeItem("Milk", "Food");

        findItemsByCategory("Food");

        Map<String, List<Product>> categoryProduct = groupProductsByCategory(products);
        printProductsByCategory(categoryProduct);
    }
}
