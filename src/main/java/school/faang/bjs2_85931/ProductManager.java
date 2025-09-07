package school.faang.bjs2_85931;

import java.util.*;
import school.faang.bjs2_85931.Product.Category;

public class ProductManager {
    private static final Set<Product> products = new HashSet<>();
    private static int product_id = 1;

    private ProductManager() {

    }

    public static void addProduct(Category category, String productName) {
        for (Product product : products) {
            if (product.productName().equals(productName) && product.category().equals(category)) {
                System.out.println("Такой товар уже есть в категории " + category);
                return;
            }
        }
        Product product = new Product(product_id++, productName, category);
        products.add(product);
    }

    public static void removeProduct(Category category, String productName) {
        products.removeIf(product -> product.productName().equals(productName) && product.category().equals(category));
    }

    public static List<Product> findProductsByCategory(Category category) {
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if (product.category().equals(category)) {
                list.add(product);
            }
        }
        return list;
    }

    public static Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> grouped = new HashMap<>();
        for (Product product : products) {
            grouped.computeIfAbsent(product.category(), k -> new ArrayList<>()).add(product);
        }
        return grouped;
    }

    public static void printAllProducts() {
        Map<Category, List<Product>> allProductsByCategory = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> product : allProductsByCategory.entrySet()) {
            System.out.println(product.getKey());
            for (Product productData : product.getValue()) {
                System.out.printf("- %s" + "\n", productData.productName());
            }
            System.out.println();
        }
    }
}