package school.faang.task_45086;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addItem(String category, String name) {
        int id = new Random().nextInt(0, 100);
        Product product = new Product(id, name, category);
        this.products.add(product);
    }

    public void removeItem(String category, String name) {
        Iterator<Product> productsIterator = this.products.iterator();
        while (productsIterator.hasNext()) {
            Product product = productsIterator.next();
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                productsIterator.remove();
                return;
            }
        }
        throw new NoSuchElementException("There is no product with the category " + category + " and the name" + name);
    }

    public void findItemsByCategory(String category) {
        Map<String, Set<Product>> groupedProducts = new HashMap<>();
        this.products.forEach(product -> {
            if (product.getCategory().equals(category)) {
                groupedProducts.computeIfAbsent(product.getCategory(), k -> new HashSet<>()).add(product);
            }
        });

        groupedProducts.forEach((currentCategory, products) -> {
            System.out.println(currentCategory + ":");
            products.forEach(System.out::println);
        });
    }

    public void printAllItems() {
        Map<String, Set<Product>> groupedProducts = new HashMap<>();
        this.products.forEach(product -> {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new HashSet<>()).add(product);
        });

        groupedProducts.forEach((category, products) -> {
            System.out.println(category + ":");
            products.forEach(System.out::println);
        });
    }

    public Map<String, Set<Product>> groupProductsByCategory() {
        Map<String, Set<Product>> groupedProducts = new HashMap<>();
        this.products.forEach(product -> {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new HashSet<>()).add(product);
        });
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, Set<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            System.out.println(category + ":");
            products.forEach(System.out::println);
        });
    }
}
