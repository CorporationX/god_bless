package school.faang.bjs269869;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private int id = 1;
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(id, name, category));
        id++;
    }

    public void removeProduct(Category category, String name) {
        List<Product> toDelete = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                toDelete.add(product);
            }
        }
        products.removeAll(toDelete);
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
        Map<Category, List<Product>> grouped = new HashMap<>();
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (!(grouped.containsKey(product.getCategory()))) {
                productList = new ArrayList<>();
            }
            productList.add(product);
            grouped.put(product.getCategory(), productList);
        }
        return grouped;
    }

    public void printAllProducts() {
        for (Product product : products) {
            System.out.println("Категория: " + product.getCategory() +
                    "\nПродукты: " +
                    "\n- " + product.getName() + "\n");
        }
    }
}
