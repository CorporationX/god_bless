package school.faang.task_45116;

import lombok.Data;

import java.util.*;

@Data
public class ProductManager {
    private final Map<Category, Set<Product>> groupedProducts = new HashMap<>();

    public void addItem(Category category, String name) {
        String id = UUID.randomUUID().toString();
        Product product = new Product(id, name, category);
        groupedProducts.computeIfAbsent(category, k -> new HashSet<>()).add(product);
    }

    public void removeItem(Category category, String name) {
        Set<Product> products = groupedProducts.get(category);

        if (products == null || products.isEmpty()) {
            throw new NoSuchElementException("There is no product with the category "
                    + category
                    + " and the name "
                    + name);
        }


        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (Objects.equals(product.getName(), name)) {
                iterator.remove();

                if (products.isEmpty()) {
                    groupedProducts.remove(category);
                }
                return;
            }
        }

        throw new NoSuchElementException("There is no product with the category " + category + " and the name " + name);
    }

    public void findItemsByCategory(Category category) {
        Set<Product> products = groupedProducts.get(category);
        if (products == null || products.isEmpty()) {
            System.out.println("No products found for category: " + category);
            return;
        }

        printProductsByCategory(category, products);
    }

    public void printAllItems() {
        if (groupedProducts.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        groupedProducts.forEach(this::printProductsByCategory);
    }

    public Map<Category, Set<Product>> groupProductsByCategory() {
        return Collections.unmodifiableMap(groupedProducts);
    }

    private void printProductsByCategory(Category category, Set<Product> products) {
        System.out.println(category + ":");
        products.forEach(System.out::println);
    }
}