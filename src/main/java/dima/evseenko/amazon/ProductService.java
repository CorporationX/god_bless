package dima.evseenko.amazon;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class ProductService {
    private final Map<Long, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (Objects.nonNull(product)) {
            products.put(product.getId(), product);
        }
    }

    public void addProducts(List<Product> products) {
        if (Objects.nonNull(products)) {
            products.forEach(this::addProduct);
        }
    }

    public Product findProduct(Long id) {
        return products.get(id);
    }

    public void deleteProduct(Long id) {
        products.remove(id);
    }

    public void deleteProduct(Product product) {
        if (Objects.nonNull(product)) {
            deleteProduct(product.getId());
        }
    }

    public List<Product> getProductsByCategory(Category category) {
        return groupProductsByCategory(this.products).get(category);
    }

    public void printProducts() {
        products.forEach((id, product) -> System.out.println(id + ": " + product.getName()));
    }

    public void printGroupedProductsByCategory() {
        groupProductsByCategory(this.products).forEach((category, products) -> System.out.println(category + ": " + products));
    }

    public static Map<Category, List<Product>> groupProductsByCategory(Map<Long, Product> products) {
        if (Objects.isNull(products)) return null;

        Map<Category, List<Product>> productsByCategory = new HashMap<>();
        products.forEach((id, product) -> productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product));
        return productsByCategory;
    }
}
