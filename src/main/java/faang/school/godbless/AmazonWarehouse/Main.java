package faang.school.godbless.AmazonWarehouse;

import java.util.*;

public class Main {
    public static HashSet<Product> productSet = new HashSet<>();
    public static Map<String, List<Product>> mapProduct = new HashMap<>();

    public static void main(String[] args) {
        productSet.add(new Product(1, "Домик в деревне", "Молоко"));
        productSet.add(new Product(2, "Коровка из Кореновки", "Молоко"));
        productSet.add(new Product(3, "Веселый молочник", "Молоко"));
        productSet.add(new Product(4, "Ламбер", "Сыр"));
        productSet.add(new Product(5, "Батон", "Хлеб"));
        productSet.add(new Product(6, "Булочка с начинкой", "Хлеб"));
        System.out.println(productSet);

        groupByCategory(productSet);
        printInfo();
    }

    public static Map<String, List<Product>> groupByCategory(HashSet<Product> products) {
        for (Product product : products) {
            if (!mapProduct.containsKey(product.getCategory())) {
                mapProduct.put(product.getCategory(), new ArrayList<>());
            }
            mapProduct.get(product.getCategory()).add(product);
        }
        return mapProduct;
    }

    public static void printInfo() {
        for (Map.Entry<String, List<Product>> entry : mapProduct.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
