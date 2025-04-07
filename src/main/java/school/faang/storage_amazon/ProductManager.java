package school.faang.storage_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(category, name);
        products.add(product);
        log.info(String.format("Продукт '%s' добавлен в категорию %s%n", name, category));
    }

    public void removeProduct(Category category, String name) {
        boolean removed = products.removeIf(p -> p.getCategory() == category && p.getName().equals(name));
        if (removed) {
            log.info(String.format("Продукт '%s' удален из категории %s%n", name, category));
        } else {
            log.info(String.format("Продукт '%s' не найден в категории %s%n", name, category));
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();

        groupedProducts.forEach((category, productList) -> {
            System.out.println("\nКатегория: " + category);
            System.out.println("Продукты:");
            productList.forEach(v -> System.out.printf("- %s\n", v.getName()));
        });

        if (groupedProducts.isEmpty()) {
            System.out.println("Список продуктов пуст");
        }
    }
}
