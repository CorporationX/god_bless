package school.faang.naughtwoBSS256996;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int lastId = 0;

    public void addProduct(Category category, String name) {
        try {
            if (foundProductInSet(category, name)) {
                System.out.println("The product is already in store, no need to add.");
            } else {
                Product product = new Product(lastId++, name, category);
                products.add(product);
                if (!categoryMap.containsKey(product.getCategory())) {
                    categoryMap.put(product.getCategory(), new ArrayList<>());
                    categoryMap.get(product.getCategory()).add(product);
                } else {
                    categoryMap.get(product.getCategory()).add(product);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("The input values are incorrect. " + e.getMessage());
        }

    }

    public void removeProduct(Category category, String name) {
        if (!foundProductInSet(category, name)) {
            System.out.println("This product is not available in the store");
        } else {
            products.removeIf(product -> product.getName().equals(name)
                    && product.getCategory() == category);
            categoryMap.get(category).removeIf(product -> product.getName().equals(name)
                    && product.getCategory() == category);
            System.out.println("The product removed.");
        }
    }

    public Optional<Set<Product>> findProductsByCategory(Category category) {
        if (!categoryMap.containsKey(category)) {
            System.out.printf("No products found in category %s%n", category);
            return Optional.empty();
        } else {
            System.out.printf("Products found in category %s%n", category);
            return Optional.of(new HashSet<>(categoryMap.get(category)));
        }
    }


    public void printAllProducts() {
        for (Category category : categoryMap.keySet()) {
            System.out.printf("%nCategory: %s%nProducts:%n", category);
            for (Product product : categoryMap.get(category).stream().toList()) {
                System.out.printf("- %s%n", product.getName());
            }
        }
    }

    private boolean foundProductInSet(Category category, String name) {
        if (!(products.isEmpty())) {
            for (Product product : products) {
                if (product.getName().equals(name)
                        && product.getCategory().equals(category)) {
                    return true;
                }
            }
        }
        return false;
    }
}


