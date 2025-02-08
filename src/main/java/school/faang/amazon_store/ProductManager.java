package school.faang.amazon_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products;
    private final Map<Category, List> categoryMap;
    private int currentId = 1;

    public ProductManager() {
        products = new HashSet<>();
        categoryMap = new HashMap<>();
    }

    // Blouse,
    void addProduct(Category category, String name) {
        int id = currentId++;
        Product product = new Product(id, name, category);
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        var listProducts = categoryMap.get(category);
        if (!listProducts.contains(product)) {
            listProducts.add(product);
        }
    }

    void removeProduct(Category category, String name) {
        for (Map.Entry<Category, List> entry : categoryMap.entrySet()) {
            List<Product> productList = entry.getValue();
            if (productList != null) {
                productList.removeIf(product -> product.getName().equals(name));
            }
        }

        products.removeIf(product -> product.getCategory().equals(category)
                && product.getName().equals(name));
    }

    List findProductsByCategory(Category category) {
        return categoryMap.get(category);
    }

    void groupProductsByCategory() {
        var newMap = new HashMap<Category, List<Product>>();

        for (Product product : products) {
            newMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            var listProducts = newMap.get(product.getCategory());
            if (listProducts != null) {
                listProducts.add(product);
            }
        }
    }

    void printAllProducts() {
        categoryMap.forEach((k, v) -> {
            System.out.println("Category: " + k);
            List<Product> productList = v;
            System.out.println("Products:");
            productList.forEach(product -> System.out.println(product.getId() +
                    ". " + product.getName()));
        });
    }

    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.CLOTHING, "blouse");
        productManager.addProduct(Category.CLOTHING, "blouse");
        productManager.addProduct(Category.CLOTHING, "blouse");
        productManager.addProduct(Category.FOOD, "apple");
        productManager.addProduct(Category.ELECTRONICS, "TV");

        productManager.printAllProducts();
        productManager.removeProduct(Category.CLOTHING, "blouse");
        productManager.printAllProducts();
    }
}
