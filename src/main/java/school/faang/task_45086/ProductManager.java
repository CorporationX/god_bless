package school.faang.task_45086;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addItem(Category category, String name) {
        int id = new Random().nextInt(0, 100);
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeItem(Category category, String name) {
        Iterator<Product> productsIterator = products.iterator();
        while (productsIterator.hasNext()) {
            Product product = productsIterator.next();
            if (Objects.equals(product.getName(), name) && Objects.equals(product.getCategory(), category)) {
                productsIterator.remove();
                return;
            }
        }
        throw new NoSuchElementException("There is no product with the category " + category + " and the name" + name);
    }

    public void findItemsByCategory(Category category) {
        Map<Category, Set<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> {
            if (Objects.equals(product.getCategory(), category)) {
                groupedProducts.computeIfAbsent(
                        product.getCategory(),
                        k -> new HashSet<>()
                ).add(product);
            }
        });

        groupedProducts.forEach((currentCategory, products) -> {
            System.out.println(currentCategory + ":");
            products.forEach(System.out::println);
        });
    }

    public void printAllItems() {
        Map<Category, Set<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> {
            groupedProducts.computeIfAbsent(
                    product.getCategory(),
                    k -> new HashSet<>()
            ).add(product);
        });

        groupedProducts.forEach((category, products) -> {
            System.out.println(category + ":");
            products.forEach(System.out::println);
        });
    }

    public Map<Category, Set<Product>> groupProductsByCategory() {
        Map<Category, Set<Product>> groupedProducts = new HashMap<>();
        products.forEach(product -> {
            groupedProducts.computeIfAbsent(
                    product.getCategory(),
                    k -> new HashSet<>()
            ).add(product);
        });
        return groupedProducts;
    }

    public void printProductsByCategory(Map<Category, Set<Product>> groupedProducts) {
        groupedProducts.forEach((category, products) -> {
            System.out.println(category + ":");
            products.forEach(System.out::println);
        });
    }
}
