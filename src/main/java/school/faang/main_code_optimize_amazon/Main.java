package school.faang.main_code_optimize_amazon;

import java.util.*;

public class Main {
    private static Set<Product> productsSet = new HashSet<>();
    private Map<String, List<Product>> productsMap = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();

        Product firstProduct = new Product(1, "milk", "1");
        Product secondProduct = new Product(2, "water", "2");
        Product thirdProduct = new Product(3, "energydrink", "2");

        productsSet.add(firstProduct);
        productsSet.add(secondProduct);
        productsSet.add(thirdProduct);

        main.groupedProductsByCategory(productsSet);

        main.printProductsByCategory();
    }

    public Map<String, List<Product>> groupedProductsByCategory(Set<Product> products) {
        for (Product product : products) {
            productsMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return productsMap;
    }

    public void printProductsByCategory() {
        for(Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
