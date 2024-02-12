package faang.school.godbless.AmazonWarehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Product> products = new HashSet<>();
    public static void main(String[] args) {
        products.add(new Product(1, "Кофе", "Чай и кофе"));
        products.add(new Product(2, "Чай", "Чай и кофе"));
        products.add(new Product(3, "Пепси", "Напитки"));
        products.add(new Product(4, "Кола", "Напитки"));
        printAll();
    }

    public static Map<String, List<Product>> groupProduct(Set<Product> productSet) {
        Map<String, List<Product>> groupsProducts = new HashMap();
        for (Product product : productSet) {
            groupsProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupsProducts;
    }

    public static void printAll() {
        Map<String, List<Product>> groupsProducts = groupProduct(products);
        for (Map.Entry entry : groupsProducts.entrySet()) {
            System.out.println(String.format("Категория: \"%s\".", entry.getKey()));
            Set<Product> products123 = products;
            for (Product product : products123) {
                System.out.println("Продукт: " + product.getName());
            }
        }
    }
}
