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
        if (foundProductInSet(category, name)) {
            System.out.println("The product is already in store, no need to add.");
        } else {
            Product product = new Product(lastId++, name, category);
            products.add(product);
            if (!categoryMap.containsKey(category)) {
                categoryMap.put(category, new ArrayList<>());
                categoryMap.get(category).add(product);
            } else {
                categoryMap.get(category).add(product);
            }
            lastId++;
        }
    }

    public void removeProduct(Category category, String name) {
        if (!foundProductInSet(category, name)) {
            System.out.println("This product is not available in the store");
        } else {
            products.removeIf(product -> product.getName().equals(name)
                    && product.getCategory().equals(category));
            categoryMap.get(category).removeIf(product -> product.getName().equals(name)
                    && product.getCategory().equals(category));
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

    //В задании указан метод groupProductsByCategory(): обновляет categoryMap,
    //группируя все текущие продукты в множество по их категориям.
    //Не совсем понятен смысл этого метода, так как группировка в мапу происходит в addProduct.
    //И не понятно каким образом организовать обновление мапы, если каждый ключ и так уникален, а множество создается
    //под конкретный ключ.

    public void printAllProducts() {
        for (Category category : categoryMap.keySet()) {
            System.out.printf("%nCategory: %s%nProducts:%n", category);
            for (Product product : categoryMap.get(category).stream().toList()) {
                System.out.printf("- %s%n", product.getName());
            }
        }
    }

    private boolean foundProductInSet(Category category, String name) {
        boolean found = false;
        if (!(products.isEmpty())) {
            for (Product product : products) {
                if (product.getName().equals(name)
                        && product.getCategory().equals(category)) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
}


