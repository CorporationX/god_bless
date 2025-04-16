package school.faang.amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductManager {

    private final Set<Product> productSet = new HashSet<>();

    public boolean addProduct(int id, Category category, String name) {
        Product product = new Product(id, name, category);
        return productSet.add(product);
    }

    public void removeProduct(Category category, String name) {
        productSet.removeIf(product ->
                Objects.equals(product.getCategory(), product.getName())
        );
        System.out.println(productSet);
    }

    public Set<Product> findProductByCategory(Category category) {
        return productSet.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toSet());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> categoryListMap = new HashMap<>();
        productSet.forEach(product -> {
            categoryListMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryListMap.get(product.getCategory()).add(product);
        });
        return categoryListMap;
    }

    public void printAllProduct() {
        Map<Category, List<Product>> categoryListMap = groupProductsByCategory();
        categoryListMap.forEach((category, products) -> {
            products.forEach(product -> System.out.println(" Product" + product));
        });
    }
}
