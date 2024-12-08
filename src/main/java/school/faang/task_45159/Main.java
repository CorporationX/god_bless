package school.faang.task_45159;

import java.util.*;

public class Main {

    private static final HashSet<Product> products = new HashSet<>();

    public static void main(String[] args) {

        addItem(1, "Milk", "Drinking");
        addItem(2, "Tomato", "Vegetables");
        addItem(3, "Cola", "Drinking");
        addItem(4, "Potato", "Vegetables");
        addItem(5, "Tea", "Drinking");
        addItem(6, "SmartPhone", "Devices");

        addItem(7, "Windows", "OC");
        printAllItems();
        System.out.println("----------------------");

        findItemsByCategory("Drinking");
        System.out.println("----------------------");

        removeItem(6, "SmartPhone", "Devices");
        System.out.println("----------------------");

        printAllItems();
        groupedProducts(groupProductsByCategory(products));
    }

    public static void addItem(int id, String name, String category) {
        products.add(new Product(id, name, category));
    }

    public static void removeItem(int id, String category, String name) {
        Product removeProduct = new Product(id, name, category);

        if (products.contains(removeProduct)) {
            products.remove(removeProduct);
            System.out.println("Products with id: " + id + " was deleted");
        } else {
            System.out.println("Products with id: " + id + " not found");
        }
    }

    public static void findItemsByCategory(String category) {
        int count = 0;
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.println("id: " + product.getId() + " name: " + product.getName());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("This category is not found");
        }
    }

    public static void printAllItems() {
        for (Product product : products) {
            System.out.println("All items: " + product.getName());
        }
    }

    public static void groupedProducts(Map<String, List<Product>> groupedProducts) {

        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey() + " Categories: ");
            for (Product product : entry.getValue()) {
                System.out.println("id: " + product.getId() + " name: " + product.getName());
            }
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> mapProduct = new HashMap<>();

        for (Product product : products) {
            if (mapProduct.containsKey(product.getCategory())) {
                mapProduct.get(product.getCategory()).add(product);
            } else {
                mapProduct.put(product.getCategory(), new ArrayList<>());
                mapProduct.get(product.getCategory()).add(product);
            }
        }
        return mapProduct;
    }
}


