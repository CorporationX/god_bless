package school.faang.sprint_1.warehouse_structuring;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int id = 0;

    public void addProduct(Category category, String name) throws Exception {
        if (category == null
                || name == null
                || name.isBlank()) {
            throw new Exception("Category can't be null or empty");
        }
        id++;
        products.add(new Product(id, name, category));
        log.info("products {} created", id);
    }

    public void removeProduct(Category category, String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }
        products.removeIf(
                product -> Objects.equals(product.getName(), name)
                        && Objects.equals(product.getCategory(), category));
    }

    public List<Product> findProductsByCategory(Category category) {
        return products.stream().filter(
                product -> Objects.equals(product.getCategory(), category)).toList();
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(product -> product.getCategory()));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            Category category = entry.getKey();
            List<Product> productList = entry.getValue();

            System.out.println("Категория: " + category);
            System.out.println("Продукты:");

            for (Product product : productList) {
                System.out.println("- " + product.getName());
            }

            System.out.println();
        }
    }
}