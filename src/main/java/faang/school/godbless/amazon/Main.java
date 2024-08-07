package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Product> products = new HashSet<>();

    static {
        products.add(new Product(1, "Cat's food", "For pets"));
        products.add(new Product(2, "Dog's food", "For pets"));
        products.add(new Product(3, "Weight", "Sport"));
        products.add(new Product(4, "Bred", "Food"));
        products.add(new Product(5, "Milk", "Food"));
    }

    public static void main(String[] args) {
        printAll(getCategoryProductsMap());
    }

    private static Map<String, List<Product>> getCategoryProductsMap() {
        Map<String, List<Product>> categoryProductMap = new HashMap<>();

        for (Product product : products) {
            categoryProductMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return categoryProductMap;
    }

    private static void printAll(Map<String, List<Product>> categoryProduct) {
        for (Map.Entry<String, List<Product>> categoryProductsEntry : categoryProduct.entrySet()) {
            System.out.println(categoryProductsEntry.getKey());
            categoryProductsEntry.getValue().forEach(product -> System.out.println("\t" + product));
        }
    }
}
