package faang.school.godbless.module1.sprint1.task12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static final Set<Product> PRODUCTS = new HashSet<>();
    public static final Map<String, List<Product>> PRODUCT_BY_CATEGORY = new HashMap<>();
    public static void main(String[] args) {
        PRODUCTS.add(new Product(1,"Potato","Food"));
        PRODUCTS.add(new Product(2,"Carrot","Food"));
        PRODUCTS.add(new Product(3,"Beer","Drink"));
        PRODUCTS.add(new Product(4,"Mahito","Drink"));
        addProductsInCategory(PRODUCTS);
        printAllCategories();

    }

    public static void addProductsInCategory(Set<Product> products) {
        for (Product product : products) {
            PRODUCT_BY_CATEGORY.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }
    }

    public static void printAllCategories() {
        for (Map.Entry<String, List<Product>> entry : PRODUCT_BY_CATEGORY.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
