package school.faang.sprint_1.task_45180;

import java.util.*;

public class ProductService {
    private final HashSet<Product> products = new HashSet<>();

    public void addItem(String category, String name) {
        int id = generateId();
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeItem(String category, String name) {
        boolean removed = products.removeIf(product -> product.getCategory()
                .equals(category) && product.getName()
                .equals(name));
        if (!removed) {
            System.out.println("Такого продукта нет: " + name);
        }
    }

    public List<Product> findItemsByCategory(String category) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public void printAllItems() {
        if (products.isEmpty()) {
            System.out.println("Товар отсутствует в магазине.");
        } else {
            products.forEach(System.out::println);
        }
    }

    public Map<String, List<Product>> groupProductsByCategory() {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }
        return groupedProducts;
    }

    private int generateId() {
        return (int) (Math.random() * 10000);
    }
}
