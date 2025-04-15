package school.faang.amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class ProductManager {

    private final Set<Product> productSet = new HashSet<>();

    public boolean addProduct(int id,Category category, String name) {
        Product product = new Product(id, name, category);
        return productSet.add(product);
    }

    public void removeProduct(Category category, String name) {
        productSet.removeIf(product ->
                product.getCategory().equals(category) && product.getName().equals(name)
        );
        System.out.println(productSet);
    }

    public Set<Product> findProductByCategory(Category category) {
        Set<Product> productFindCategory = new HashSet<>();
        productFindCategory.add(productSet.stream()
                .filter(product -> product.getCategory().equals(category))
                .findFirst()
                .orElseThrow());
        return productFindCategory;
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
