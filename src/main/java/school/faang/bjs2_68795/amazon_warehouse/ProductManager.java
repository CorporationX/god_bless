package school.faang.bjs2_68795.amazon_warehouse;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    private static final String PRODUCT_NOT_FOUND = "Product with name {} and category {} is not found";
    private static final String PRODUCT_ALREADY_EXISTS = "Product with name {} and category {} is already exists";

    Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                log.error(PRODUCT_ALREADY_EXISTS, name, category);
                throw new ProductAlreadyExistsException(PRODUCT_ALREADY_EXISTS, name, category);
            }
        }
        Product product = new Product(name, category);
        products.add(product);
        log.info("Product {} is inserted", product);
    }

    public void removeProduct(Category category, String name) {
        boolean isFound = false;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                isFound = true;
                products.remove(product);
                break;
            }
        }
        if (!isFound) {
            log.error(PRODUCT_NOT_FOUND, name, category);
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND, name, category);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> categoryList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                categoryList.add(product);
            }
        }
        return categoryList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupedProductsMap = new HashMap<>();
        for (Product product : products) {
            groupedProductsMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            groupedProductsMap.get(product.getCategory()).add(product);
        }
        return groupedProductsMap;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupProductsByCategoryMap = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupProductsByCategoryMap.entrySet()) {
            log.info("Category: {}", entry.getKey());
            log.info("Products:");
            for (Product product : entry.getValue()) {
                log.info("- {}", product.getName());
            }
            log.info("");
        }
    }
}