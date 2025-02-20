package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ProductManager {
    private final Set<Product> products = new HashSet<>();
    private final Map<Product.Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Product.Category category, String name) {
        Random random = new Random();
        int id = random.nextInt(Integer.MAX_VALUE);
        Product product = new Product(category, name, id);
        products.add(product);
        categoryMap.computeIfAbsent(category, key -> new ArrayList<Product>()).add(product);
    }

    public boolean checkIfExists(int id) {
        return true;
    }

    public void removeProduct(Product.Category category, String name) {
        Product productToDelete = null;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                productToDelete = product;
                iterator.remove();
            }
        }

        List<Product> productList = categoryMap.get(category);
        if (!productList.isEmpty()) {
            productList.remove(productToDelete);
        }
        if (productList.isEmpty()) {
            categoryMap.remove(category);
        }
    }

    public List<Product> findProductsByCategory(Product.Category category) {
        return categoryMap.get(category);
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Product.Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println("Products: ");
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }
}
