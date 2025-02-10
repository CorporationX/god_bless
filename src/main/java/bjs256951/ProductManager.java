package bjs256951;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Getter(value = AccessLevel.PROTECTED)
public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private static int globalId = 0;
    private static final Logger logger = LoggerFactory.getLogger(ProductManager.class);

    protected void addProduct(Category category, String name) {
        if (Objects.isNull(category) || Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("The fields are not filled in");
        }
        Product product = new Product(++globalId, name, category);
        products.add(product);

        List<Product> productsInCategoryMap = categoryMap.get(category);
        if (productsInCategoryMap == null) {
            productsInCategoryMap = new ArrayList<>();
        }
        productsInCategoryMap.add(product);
        categoryMap.put(category, productsInCategoryMap);
    }

    protected void removeProduct(Category category, String name) {
        for (Iterator<Product> productIterator = products.iterator(); productIterator.hasNext(); ) {
            if (productIterator.next().getName().equals(name)) {
                productIterator.next();
                if (Objects.nonNull(productIterator.next()) && findProductsByCategory(category) != null) {
                    categoryMap.forEach((key, value) -> categoryMap.get(key)
                            .removeIf(productInList -> productInList.getName().equals(name)));
                    productIterator.remove();
                }
            }
        }
    }

    protected List<Product> findProductsByCategory(Category category) {
        return categoryMap.get(category).stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    protected Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.merge(product.getCategory(), new ArrayList<>(),
                    (categoryInMap, products) -> {
                        productMap.get(product.getCategory()).add(product);
                        return productMap.get(product.getCategory());
                    });
        }
        return productMap;
    }

    protected void printAllProducts() {
        for (Map.Entry<Category, List<Product>> categoryToProducts : categoryMap.entrySet()) {
            Category category = categoryToProducts.getKey();
            List<Product> products = categoryToProducts.getValue();
            logger.info("Category: {}", category);
            logger.info("Products:");
            for (int i = 0; i < products.size(); i++) {
                logger.info("- {}", products.get(i).getName());
                if (i == (products.size() - 1)) {
                    logger.info("");
                }
            }
        }
    }
}
