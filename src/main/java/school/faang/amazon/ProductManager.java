package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product newProduct = new Product(name, category);
        products.add(newProduct);
    }
    
    public void removeProduct(Category category, String name) {
        products.removeIf(product ->
                product.getCategory() == category
                        && product.getName().equals(name));
    }

    public List<String> findByCategory(Category category) {
        List<String> itemList = products.stream()
                    .filter(product -> product.getCategory() == category)
                    .map(Product::getName)
                    .toList();
        return itemList;
    }

    public Map<Category, List<Product>> groupProductsByCategory()  {
        Map<Category, List<Product>> group = new HashMap<>();
        List<Product> foodList = new ArrayList<>();
        for (Category category : Category.values()) {
            List<Product> itemList = products.stream()
                    .filter(product -> product.getCategory() == category)
                    .toList();
            group.put(category, itemList);
        }
        return group;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> grouped = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : grouped.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }
}
