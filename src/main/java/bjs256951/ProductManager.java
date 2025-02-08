package bjs256951;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();
    public static int globalId = 0;
    private static final Logger logger = LoggerFactory.getLogger(ProductManager.class);

    void addProduct(Category category, String name) {
        globalId++;
        int id = globalId;
        Product product = new Product(id, name, category);
        products.add(product);
        if (categoryMap.get(category) == null) {
            List<Product> newValueInCategoryMap = new ArrayList<>();
            newValueInCategoryMap.add(product);
            categoryMap.put(category, newValueInCategoryMap);
        } else {
            categoryMap.get(category).add(product);
        }
    }

    void removeProduct(Category category, String name) {
        Product foundProduct = null;
        for (List<Product> listProducts : categoryMap.values()) {
            Optional<Product> optionalFoundProduct =
                    listProducts.stream()
                            .filter(product -> !product.getName().isBlank() && product.getName().equals(name))
                            .findFirst();
            if (optionalFoundProduct.isPresent()) {
                foundProduct = optionalFoundProduct.get();
            }
            products.remove(foundProduct);
            if (Objects.nonNull(category)) {
                categoryMap.get(category).remove(foundProduct);
            }
        }
    }

    List<Product> findProductsByCategory(Category category) {
        List<Product> foundByCategoryProducts = new ArrayList<>();
        if (categoryMap.get(category) != null) {
            foundByCategoryProducts = categoryMap.get(category);
        }
        return foundByCategoryProducts;
    }

    Map<Category, Set<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.toSet()));
    }

    void printAllProducts() {
        for (Map.Entry<Category, List<Product>> categoryToProducts : categoryMap.entrySet()) {
            Category category = categoryToProducts.getKey();
            List<Product> products = categoryToProducts.getValue();
            logger.info("Category: {} %n", category);
            logger.info("Products: %n");
            for (int i = 0; i < products.size(); i++) {
                logger.info("- {} %n", products.get(i).getName());
                if (i == (products.size() - 1)) {
                    logger.info("");
                }
            }
        }
    }
}
