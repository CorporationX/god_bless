package dima.evseenko.amazon;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon {
    @Getter
    private final Map<Long, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        validateProduct(product);

        products.put(product.getId(), product);
    }

    public void addProducts(List<Product> products) {
        validateProducts(products);

        products.forEach(this::addProduct);
    }

    public Product findProduct(Long id) {
        return products.get(id);
    }

    public void deleteProduct(Long id) {
        products.remove(id);
    }

    public void deleteProduct(Product product) {
        deleteProduct(product.getId());
    }

    public void deleteProducts(List<Product> products) {
        products.forEach(this::deleteProduct);
    }

    public List<Product> getProductsByCategory(Product.Category category) {
        List<Product> productsByCategory = new ArrayList<>();
        products.forEach((id, product) -> {
            if(product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        });
        return productsByCategory;
    }

    public void printProducts() {
        products.forEach((id, product) -> System.out.println(id+": "+product.getName()));
    }

    public void printGroupedProductsByCategory() {
        groupProductsByCategory(this.products).forEach((category, products) -> System.out.println(category+": "+products));
    }

    private void validateProduct(Product product) {
        if(product == null)
            throw new IllegalArgumentException("product is null");
        if(product.getId() == null)
            throw new IllegalArgumentException("product id is null");
        if(product.getName() == null)
            throw new IllegalArgumentException("product name is null");
        if(product.getCategory() == null)
            throw new IllegalArgumentException("product category is null");
    }

    private void validateProducts(List<Product> products) {
        if(products == null)
            throw new IllegalArgumentException("products is null");
    }

    public static Map<Product.Category, List<Product>> groupProductsByCategory(Map<Long, Product> products) {
        Map<Product.Category, List<Product>> productsByCategory = new HashMap<>();
        products.forEach((id, product) -> productsByCategory.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product));
        return productsByCategory;
    }
}
