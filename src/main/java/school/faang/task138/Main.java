package school.faang.task138;

import java.util.*;

public class Main {

    private static final HashSet<Product> PRODUCTS = new HashSet<>();

    public static HashMap<String, List<Product>> getProductMap(HashSet<Product> products) {
        HashMap<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public static void printProductsByGroup() {
        for (Map.Entry<String, List<Product>> entry : getProductMap(PRODUCTS).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Product firstProduct = new Product(0, "Мяч для собаки", "Зоотовары");
        Product secondProduct = new Product(1, "Ноубук acer", "Техника");
        Product thirdProduct = new Product(2, "Планшет леново", "Техника");
        Product fourthProduct = new Product(3, "Заводная мышка для кошки", "Зоотовары");
        Product fifthroduct = new Product(4, "Помада", "Косметика");

        PRODUCTS.add(firstProduct);
        PRODUCTS.add(secondProduct);
        PRODUCTS.add(thirdProduct);
        PRODUCTS.add(fourthProduct);
        PRODUCTS.add(fifthroduct);

        printProductsByGroup();
    }
}
