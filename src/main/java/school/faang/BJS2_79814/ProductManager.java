package school.faang.BJS2_79814;

import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(new Random().nextInt(), name, category);
        products.add(product);
    }

    //Без id? В hashcode и equal не включать id или сделать перегрузку конструктора для создания без id?
    // Зачем в рамках задачи id, он нигде не используется?
    public void removeProduct(Category category, String name) {
        Product product = new Product(new Random().nextInt(), name, category);
        products.remove(product);
    }

    public Set<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        groupedProducts.forEach(((category, products) -> {
            System.out.println("Категория: " + category);
            products.forEach(product -> System.out.println("- " + product.getName()));
            System.out.println();
        }));
    }

}
