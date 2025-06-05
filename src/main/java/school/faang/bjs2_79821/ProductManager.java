package school.faang.bjs2_79821;

import java.util.*;

public class ProductManager {
    private static final Set<Product> PRODUCTS = new HashSet<>();
    private int currentId = 0;

    public void addProduct(Category category, String name) {
        for (Product product : PRODUCTS) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("A product with that name already exists in the category" + category);
                return;
            }
        }
        Product product = new Product(currentId++, name, category);
        PRODUCTS.add(product);
        System.out.println("Added product " + product);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:WhitespaceAround"})
    public void removeProduct(Category category, String name) {
        Product toRemove = null;
        for (Product product : PRODUCTS) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                toRemove = product;
                break;
            }
        }
        if (toRemove == null) {
            System.out.println("Product \"" + name + "\" not found in category \"" + category + "\".");
            return;
        }

        PRODUCTS.remove(toRemove);
        System.out.println("Product \"" + name + "\" removed from category \"" + category + "\".");
    }

    public Set<Product> findProductsByCategory(Category category) {
        Set<Product> result = new HashSet<>();
        if (category == null) {
            return result;
        }
        for (Product product : PRODUCTS) {
            if (category.equals(product.getCategory())) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();

        for (Product product : PRODUCTS) {
            Category category = product.getCategory();
            if (!productMap.containsKey(category)) {
                productMap.putIfAbsent(category, new ArrayList<>());
            }
            productMap.get(category).add(product);
        }

        return productMap;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> grouped = groupProductsByCategory();
        for (Category category : grouped.keySet()) {
            System.out.println("Category: " + category);
            System.out.println("Products:");
            for (Product product : grouped.get(category)) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-Shirt");

        System.out.println("\nAll products grouped by category:");
        manager.printAllProducts();

        System.out.println("Products in FOOD category:");
        for (Product p : manager.findProductsByCategory(Category.FOOD)) {
            System.out.println("- " + p.getName());
        }

        System.out.println("\nRemoving product 'Bread' from FOOD category...");
        manager.removeProduct(Category.FOOD, "Bread");

        System.out.println("\nProducts after removal:");
        manager.printAllProducts();
    }
}