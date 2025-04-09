package school.faang.bjs2_68689;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    private long id;

    public void addProduct(Category category, String name) {
        products.add(Product.builder().id(id).category(category).name(name).build());
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name));
    }

    public Set<Product> findProductsByCategory(Category category) {
        return products.stream().filter(p -> p.getCategory().equals(category)).collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        groupProductsByCategory().forEach((category, products) -> {
            log.info("\nКатегория: {}\n", category);
            log.info("\nПродукты:\n");
            products.forEach(product -> log.info("- {}\n", product.getName()));
        });
    }
}
