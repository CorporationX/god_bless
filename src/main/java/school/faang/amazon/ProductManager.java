package school.faang.amazon;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
    }

    public void removeProduct(Category category, String name) {
        products.remove(new Product(name, category));
    }

    public List<Product> findProductByCategory(Category category) {
        return products.stream().filter(product -> product.getCategory() == category).toList();
    }

    public Map<Category, List<Product>> groupProductByCategory() {
        Map<Category, List<Product>> productsGroupedByCategory = new HashMap<>();

        for (Category category : Category.values()) {
            productsGroupedByCategory.put(category, findProductByCategory(category));
        }

        return productsGroupedByCategory;
    }

    public String printAllProducst() {
        Map<Category, List<Product>> productsGroupedByCategory = groupProductByCategory();
        StringBuilder productsGroupedByCategoryStringBuilder = new StringBuilder();

        for (Map.Entry<Category, List<Product>> kv : productsGroupedByCategory.entrySet()) {
            productsGroupedByCategoryStringBuilder.append("Category: ").append(kv.getKey()).append("\n");
            productsGroupedByCategoryStringBuilder.append("Products: ").append("\n");
            for (Product product : kv.getValue()) {
                productsGroupedByCategoryStringBuilder.append("- ").append(product.getName()).append("\n");
            }
        }

        return productsGroupedByCategoryStringBuilder.toString();
    }
}
