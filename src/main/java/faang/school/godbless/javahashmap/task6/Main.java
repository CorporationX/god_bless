package faang.school.godbless.javahashmap.task6;

import java.util.*;

public class Main {

    private static final Set<Product> productsSet = new HashSet<>();

    public static void main(String[] args) {
        productsSet.add(new Product(1, "Apple MacBook Pro 16", "Electronics"));
        productsSet.add(new Product(2, "Samsung Galaxy S23 Ultra", "Electronics"));
        productsSet.add(new Product(3, "Nike Air Max 97", "Shoes"));
        productsSet.add(new Product(4, "Sony PlayStation 5", "Electronics"));
        productsSet.add(new Product(5, "Adidas Ultraboost 22", "Shoes"));
        productsSet.add(new Product(6, "Levi's 501 Jeans", "Clothing"));
        productsSet.add(new Product(7, "Philips Hue Starter Kit", "Lighting"));
        productsSet.add(new Product(8, "Bose QuietComfort 45", "Audio"));
        productsSet.add(new Product(9, "Nespresso Vertuo Next", "Coffee Machines"));
        productsSet.add(new Product(10, "Instant Pot Duo Crisp", "Kitchen Appliances"));

        HashMap<String, List<Product>> mapProducts = groupProductsByCategory(productsSet);
        printProductsMap(mapProducts);
    }

    public static HashMap<String, List<Product>> groupProductsByCategory(Set<Product> productsSet) {
        HashMap<String, List<Product>> productsMap = new HashMap<>();
        for (Product product : productsSet) {
            if (productsMap.containsKey(product.getCategory())) {
                productsMap.get(product.getCategory()).add(product);
            } else {
                productsMap.put(product.getCategory(), new ArrayList<>(Arrays.asList(product)));
            }
        }
        return productsMap;
    }

    public static void printProductsMap(HashMap<String, List<Product>> productsMap) {
        productsMap.forEach((s, products) -> {
            System.out.println("Category " + s);
            products.forEach(System.out::println);
            System.out.println();
        });
    }
}
