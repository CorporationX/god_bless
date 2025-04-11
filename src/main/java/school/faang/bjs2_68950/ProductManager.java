package school.faang.bjs2_68950;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                return;
            }
        }
        products.add(new Product(category, name));
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getName().equals(name) && product.getCategory().equals(category));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productList.add(product);
            }
        }
        return productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupByCategory = groupProductsByCategory();
        for (var entity : groupByCategory.entrySet()) {
            System.out.printf("Category: %s\n", entity.getKey().name())
                    .print("Products:\n");
            entity.getValue().forEach(product -> System.out.printf("\t- %s\n", product.getName()));
        }
    }
}
