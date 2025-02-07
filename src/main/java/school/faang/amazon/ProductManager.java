package school.faang.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private Set products = new HashSet<>();
    private Map<Category, List> categoryMap = new HashMap<>();


    public Product addProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (products.contains(product)) {
            throw new IllegalArgumentException("Продукт %s уже существует".formatted(product));
        }

        return null;

    }
}
