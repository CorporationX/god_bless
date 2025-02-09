package school.faang.BJS2_56934;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ProductManager {

    private final Set<Product> products = new HashSet<>();
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();

    public Product addProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (products.contains(product)) {
            throw new IllegalArgumentException("Продукт %s уже существует в категории %s"
                    .formatted(product.getName(), category));
        }
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);

        return product;
    }

    public void removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (!products.contains(product)) {
            throw new NoSuchElementException("Такого продукта %s в категории %s нет"
                    .formatted(product.getName(), category));
        }
        products.remove(product);

        List<Product> productList = categoryMap.get(category);
        if (productList != null) {
            productList.removeIf(e -> e.getName().equals(product.getName()));
            if (productList.isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        }
        return categoryMap;
    }

    public String printAllProducts() {
        if (categoryMap.isEmpty()) {
            throw new IllegalArgumentException("Продуктов нет");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            stringBuilder.append("Категория: ").append(entry.getKey()).append("\n");
            stringBuilder.append("Продукты:\n");
            for (Product product : entry.getValue()) {
                stringBuilder.append("- ").append(product.getName()).append("\n");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();
    }
}
