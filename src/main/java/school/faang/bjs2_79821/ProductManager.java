package school.faang.bjs2_79821;

import java.util.*;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    private int currentId = 0;

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.printf(
                        "A product with that name already exists in the category %s", category);
                return;
            }
        }
        Product product = new Product(currentId++, name, category);
        products.add(product);
        System.out.printf("Added product %s%n", product);
    }

    public void removeProduct(Category category, String name) {
        Product toRemove = null;
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                toRemove = product;
                break;
            }
        }
        if (toRemove == null) {
            System.out.printf("Product \"%s\" not found in category \"%s\".", name, category);
            return;
        }

        products.remove(toRemove);
        System.out.printf("Product \"%s\" removed from category \"%s\".", name, category);
    }

    public Set<Product> findProductsByCategory(Category category) {
        Set<Product> result = new HashSet<>();
        if (category == null) {
            return result;
        }
        for (Product product : products) {
            if (category.equals(product.getCategory())) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();

        for (Product product : products) {
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
            System.out.printf("Category: %s%n", category);
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

        System.out.printf("%nAll products grouped by category:%n");
        manager.printAllProducts();

        System.out.printf("Products in %s category:%n", Category.FOOD);
        for (Product p : manager.findProductsByCategory(Category.FOOD)) {
            System.out.printf("- %s%n", p.getName());
        }

        System.out.printf("%nRemoving product '%s' from %s category...%n", "Bread", Category.FOOD);
        manager.removeProduct(Category.FOOD, "Bread");

        System.out.printf("%nProducts after removal:%n");
        manager.printAllProducts();
    }
}