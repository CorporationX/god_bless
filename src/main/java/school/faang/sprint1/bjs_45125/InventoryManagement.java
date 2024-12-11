package school.faang.sprint1.bjs_45125;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class InventoryManagement {
    private final HashSet<Product> productsList = new HashSet<>();
    private final Map<String, List<Product>> productsByCategory = new HashMap<>();

    public int generateProductId() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1, 200);
    }

    public boolean checkCategoryAndName(String name, String category) {
        return (name != null) && (category != null);
    }

    public void addItem(String name, String category) {
        if (checkCategoryAndName(name, category)) {
            Product item = new Product(generateProductId(), name, category);
            productsByCategory.computeIfAbsent(category, key -> new ArrayList<>())
                    .add(item);
            productsList.add(item);
        }
    }

    public void removeItem(String name, String category) {
        if (checkCategoryAndName(name, category)) {
            boolean wasRemoved = productsList.removeIf(product -> name.equals(product.name()));
            if (wasRemoved) {
                productsByCategory.get(category).removeIf(product -> name.equals(product.name()));
            } else {
                System.out.println("Product not found");
            }
        }
    }

    public List<Product> findItemsByCategory(String category) {
        if (category == null) {
            System.out.println("Not valid data");
            return new ArrayList<>();
        } else {
            if (!productsByCategory.containsKey(category)) {
                System.out.println("Category not found");
                return new ArrayList<>();
            } else {
                printItemsByCategory(category);
                return productsByCategory.get(category);
            }
        }
    }

    public void printItemsByCategory(String category) {
        System.out.printf("Category '%s' has items: ", category);
        productsByCategory.get(category).forEach((prod) -> System.out.print(prod.name() + ", "));
    }

    public void printAllItems() {
        for (Map.Entry<String, List<Product>> categoryList : productsByCategory.entrySet()) {
            printItemsByCategory(categoryList.getKey());
            System.out.println();
        }
    }

    public HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> groupedProducts.computeIfAbsent(product.category(), value -> new ArrayList<>())
                .add(product));
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        System.out.println("print by category");
        for (Map.Entry<String, List<Product>> categoryList : groupedProducts.entrySet()) {
            printItemsByCategory(categoryList.getKey());
            System.out.println();
        }
    }
}
