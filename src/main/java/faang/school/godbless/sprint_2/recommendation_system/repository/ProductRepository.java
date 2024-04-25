package faang.school.godbless.sprint_2.recommendation_system.repository;

import faang.school.godbless.sprint_2.recommendation_system.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private final Map<Integer, Product> PRODUCTS;

    public ProductRepository() {
        this.PRODUCTS = new HashMap<>();
    }

    public void addProduct(Product product) {
        PRODUCTS.put(product.getId(), product);
    }

    public Product findProductById(int id) {
        return PRODUCTS.get(id);
    }

    public void deleteProductById(int id) {
        PRODUCTS.remove(id);
    }

    public List<Product> findAllProducts() {
        return PRODUCTS.values().stream().toList();
    }
}
