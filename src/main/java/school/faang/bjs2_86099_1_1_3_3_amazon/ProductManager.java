package school.faang.bjs2_86099_1_1_3_3_amazon;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public class ProductManager {
    private Set<Product> products = new HashSet<Product>();

    public void addProduct(Category category, String name) {
        Product product = new Product(Product.ids, name, category);
        Product.ids++;
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        products.remove(new Product(name, category));
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> group = new HashMap<Category, List<Product>>();

        for (Product product : products) {
            group.putIfAbsent(product.getCategory(), new ArrayList<Product>());
            group.get(product.getCategory()).add(product);
        }

        return group;
    }

    public List<Product> findProductsByCategory(Category category) {
        Map<Category, List<Product>> groups = groupProductsByCategory();
        return groups.getOrDefault(category, new ArrayList<Product>());
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groups = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groups.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println("\t- " + product.getName());
            }
        }
    }

}
