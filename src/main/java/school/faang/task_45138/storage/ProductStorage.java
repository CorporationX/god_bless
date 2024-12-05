package school.faang.task_45138.storage;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import school.faang.task_45138.entity.Product;

public class ProductStorage {
    public final HashSet<Product> products = new HashSet<>();

    public Boolean addItem(String category,String name ) {
        Product productToAdd = new Product(name, category);
        if (products.add(productToAdd)) {
            System.out.println("Product successfully added");
            return true;
        }
        System.out.println("Failed to add product");
        return false;
    }

    public Boolean removeItem(String category, String name) {
        if (products.removeIf(product -> product.getCategory().equals(category) && product.getName().equals(name))) {
            System.out.println("Removed product from category: " + category + " and product name: " + name);
            return true;
        }
        System.out.println("Failed to remove product from category: " + category + " and product name: " + name);
        return false;
    }

    public List<Product> findItemsByCategory(String category) {
        List<Product> productsFound = products
                .stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();

        if (productsFound.isEmpty()) {
            System.out.println("No products found");
        }
        return productsFound;
    }

    public void printAllItems() {
        System.out.println("=== All Products ===");

        products.forEach(product ->
                System.out.println(
                        "Category: " + product.getCategory() + ", Name: " + product.getName()
                )
        );

        System.out.println("====================");
    }

    public static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        return products
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts){
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
