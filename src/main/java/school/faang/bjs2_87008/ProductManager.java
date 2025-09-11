package school.faang.bjs2_87008;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    static Set<Product> products = new HashSet<>();

    public static void addProduct(Category category, String name) throws Exception {
        if (category == null || name == null) {
            throw new Exception("Категория или имя равны null.");
        }
        Product newProduct = new Product(name, category);
        products.add(newProduct);
    }

    public static void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));
    }

    public static List<Product> findProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    public static Map<Category, List<Product>> groupProductsByCategories() {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for (Product product : products) {
            List<Product> thisCategoryProducts = new ArrayList<>();
            productsByCategories.putIfAbsent(product.getCategory(), thisCategoryProducts);
            productsByCategories.get(product.getCategory())
                    .add(product);
        }
        return productsByCategories;
    }

    public static void printAllProducts(Map<Category, List<Product>> productsByCategories) {
        for (Map.Entry<Category, List<Product>> entry : productsByCategories.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
            System.out.println();
        }
    }
}
