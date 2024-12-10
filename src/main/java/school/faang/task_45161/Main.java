package school.faang.task_45161;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private final Set<Product> products = new HashSet<>();

    public void addItem(String category, String name) {
        int id = Product.getCounter();
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeItem(String category, String name) {
        List<Product> productsToRemove = new ArrayList<>();

        for (var product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                productsToRemove.add(product);
            }
        }

        if (!productsToRemove.isEmpty()) {
            products.removeAll(productsToRemove);
        } else {
            System.out.println("Product with '" + category + "' and name '" + name + "' is not found");
        }
    }

    public void findItemsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();

        for (var product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }

        System.out.println("Products in category '" + category + "': "
                + (productsByCategory.isEmpty() ? "not found" : productsByCategory));
    }

    public void printAllItems() {
        for (var product : products) {
            System.out.println(product);
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productsByCategory = new HashMap<>();

        for (var product : products) {
            String category = product.getCategory();
            productsByCategory.putIfAbsent(category, new ArrayList<>());
            productsByCategory.get(category).add(product);
        }

        return productsByCategory;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (var entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", products: " + entry.getValue());
        }
    }

    public Set<Product> getProducts() {
        return new HashSet<>(products);
    }

    public static void main(String[] args) {
        Main warehouse = new Main();

        warehouse.addItem("Food", "Milk");
        warehouse.addItem("Food", "Bread");
        warehouse.addItem("Healthcare", "Soap");
        warehouse.addItem("Healthcare", "Shampoo");
        warehouse.printAllItems();

        System.out.println();
        warehouse.removeItem("Healthcare", "Shampoo");
        warehouse.removeItem("Food", "Tea");
        warehouse.addItem("Food", "Cake");
        warehouse.printAllItems();

        System.out.println();
        warehouse.findItemsByCategory("Food");
        warehouse.findItemsByCategory("Drugs");

        System.out.println();
        printProductsByCategory(groupProductsByCategory(warehouse.getProducts()));
    }
}
