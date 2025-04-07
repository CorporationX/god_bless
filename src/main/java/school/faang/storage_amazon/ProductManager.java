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
        log.info("Продукт '{}' добавлен в категорию {}", name, category);
    }

    public void removeProduct(Category category, String name) {
        boolean isRemoved = products.removeIf(product -> product.getCategory() == category
                && product.getName().equals(name));
        if (isRemoved) {
            log.info("Продукт '{}' удален из категории {}", name, category);
        } else {
            log.info("Продукт '{}' не найден в категории {}", name, category);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();

        groupedProducts.forEach((category, productList) -> {
            System.out.printf("\nКатегория: %s\n", category);
            System.out.println("Продукты:");
            productList.forEach(product -> System.out.printf("- %s\n", product.getName()));
        });

        if (groupedProducts.isEmpty()) {
            System.out.println("Список продуктов пуст");
        }
    }
}
