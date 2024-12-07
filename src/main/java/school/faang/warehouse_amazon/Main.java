package school.faang.warehouse_amazon;

import java.util.*;

public class Main {
    static HashSet<Product> allProducts = new HashSet<>();
    static Map<String, List<Product>> groupedByCategoryProducts = new HashMap<>();

    public static void main(String[] args) {
        printAllItems();
        printProductsByCategory(groupedByCategoryProducts);

        addItem("PC", "Keyboard");
        addItem("Furniture", "Sofa");
        addItem("Car", "Wheel");
        addItem("Car", "Clutch");
        addItem("PC", "Monitor");
        addItem("Furniture", "Chair");
        addItem("Car", "Engine");
        addItem("Furniture", "Table");

        printAllItems();
        printProductsByCategory(groupedByCategoryProducts);

        removeItem("Furniture", "Chair");
        removeItem("PC", "Keyboard");

        printProductsByCategory(groupedByCategoryProducts);

        findItemsByCategory("Car").forEach(System.out::println);
    }

    private static int lastProductId = 0;

    public static void addItem(String category, String name) {
        int id = ++lastProductId;
        Product newProduct = new Product(id, name, category);
        allProducts.add(newProduct);

        groupedByCategoryProducts = groupProductsByCategory(allProducts);
        System.out.println("Added new product " + name);
    }

    public static void removeItem(String category, String name) {
        if (!allProducts.removeIf(product -> product.getName().equals(name))) {
            System.out.println("Failed attempt to delete the product: product not found");
        }

        groupedByCategoryProducts = groupProductsByCategory(allProducts);
        System.out.println("removed new product " + name);
    }

    public static List<Product> findItemsByCategory(String category) {
        System.out.println("find items by category " + category);
        return groupedByCategoryProducts.get(category);
    }

    public static void printAllItems() {
        if (allProducts.size() == 0) {
            System.out.println("products not found");
            return;
        }
        allProducts.forEach(System.out::println);
        System.out.println();
    }

    private static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();

        products.forEach(product -> {
            if (!groupedProducts.containsKey(product.getCategory())) {
                groupedProducts.put(product.getCategory(), new ArrayList<>());
            }
            List<Product> categoryProducts = groupedProducts.get(product.getCategory());
            categoryProducts.add(product);
            groupedProducts.put(product.getCategory(), categoryProducts);
        });

        return groupedProducts;
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        System.out.println("print products by category");
        if (groupedProducts.size() == 0) {
            System.out.println("products not found");
            return;
        }
        groupedProducts.entrySet().forEach(entry -> {
            System.out.println("category  = " + entry.getKey());
            entry.getValue().forEach(System.out::println);
            System.out.println();
        });
    }

}
