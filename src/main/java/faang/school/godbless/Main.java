package faang.school.godbless;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>(Set.of(
            new Product(1, "iPhone", "Electronics"),
            new Product(2, "X-box", "Electronics"),
            new Product(3, "T-Shirt", "Clothing"),
            new Product(4, "Jeans", "Clothing"),
            new Product(5, "BMW", "Car")
        ));

        HashMap<String, List<Product>> groupedProducts = groupProductsByCategory(products);

        printGroupedProducts(groupedProducts);
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            groupedProducts
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }

        return groupedProducts;
    }

    public static void printGroupedProducts(HashMap<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(product -> System.out.println("    " + product));
        });
    }
}

