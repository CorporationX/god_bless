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

        if (id == 0) {
            throw new NullPointerException("ID cannot be 0");
        }

        if (isNullOrEmptyData(category)) {
            throw new NullPointerException("Category cannot be null or empty");
        }
        if (isNullOrEmptyData(name)) {
            throw new NullPointerException("Name cannot be null or empty");
        }

        Product removeProduct = new Product(id, name, category);

        if (products.contains(removeProduct)) {
            products.remove(removeProduct);
            System.out.println("Products with id: " + id + " was deleted");
        } else {
            System.out.println("Products with id: " + id + " not found");
        }
    }

    private static boolean isNullOrEmptyData(String str) {
        return str == null || str.isEmpty();
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
        System.out.println("All items: ");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    public static void groupedProducts(Map<String, List<Product>> printGroupedProducts) {

        for (Map.Entry<String, List<Product>> entry : printGroupedProducts.entrySet()) {
            System.out.println(entry.getKey() + " Categories: ");
            for (Product product : entry.getValue()) {
                System.out.println("id: " + product.getId() + " name: " + product.getName());
            }
        }
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> mapProduct = new HashMap<>();

        for (Product product : products) {

            mapProduct.computeIfAbsent(product.getCategory(), categories -> new ArrayList<>()).add(product);


        }
        return mapProduct;
    }
}


