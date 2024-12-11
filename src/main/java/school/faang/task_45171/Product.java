package school.faang.task_45171;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private String category;

    private static Map<String, Set<String>> categoryMap = new HashMap<>();

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }

    @Override
    public String toString() {
        return "Product{" + "id="
                + id + ", name='"
                + name + '\'' + ", category='"
                + category + '\'' + '}';
    }

    public static void addItem(String category, String name) {
        categoryMap.putIfAbsent(category, new HashSet<>());
        categoryMap.get(category).add(name);
        System.out.println("Item added: " + name + " to category " + category);
    }

    public static void removeItem(String category, String name) {
        if (!categoryMap.containsKey(category)) {
            System.out.println("Category not found: " + category);
            return;
        }
        if (!categoryMap.get(category).remove(name)) {
            System.out.println("Item not found: " + name + " in category " + category);
        } else {
            System.out.println("Item removed: " + name + " from category " + category);
        }
    }

    public static void findItemsByCategory(String category) {
        if (!categoryMap.containsKey(category)) {
            System.out.println("Category not found: " + category);
            return;
        }
        System.out.println("Items in category " + category + ": " + categoryMap.get(category));
    }

    public static void printAllItems() {
        if (categoryMap.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        for (Map.Entry<String, Set<String>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Items: " + entry.getValue());
        }
    }
}
