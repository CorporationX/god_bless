package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    static Set<Product> products = new HashSet<>();

    public static void addProduct(Product.Category category, String name) {
        Product newProduct = new Product(name, category);
        products.add(newProduct);
    }

    public static void removeProduct(Product.Category category, String name) {
        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));
    }

    public static List<Product> findProductsByCategory(Product.Category category) {
        List<Product> thisCategoryProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                thisCategoryProducts.add(product);
            }
        }
        return thisCategoryProducts;
    }

    public static Map<Product.Category, List<Product>> groupProductsByCategories() {
        Map<Product.Category, List<Product>> productsByCategories = new HashMap<>();
        for (Product product : products) {
            List<Product> thisCategoryProducts = new ArrayList<>();
            productsByCategories.putIfAbsent(product.getCategory(), thisCategoryProducts);
            productsByCategories.get(product.getCategory()).add(product);
        }
        return productsByCategories;
    }

    public static void printAllProducts(Map<Product.Category, List<Product>> productsByCategories) {
        for (Map.Entry<Product.Category, List<Product>> entry : productsByCategories.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
            System.out.println();
        }
    }
}
