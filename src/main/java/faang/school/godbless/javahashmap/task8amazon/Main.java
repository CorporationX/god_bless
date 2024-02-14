package faang.school.godbless.javahashmap.task8amazon;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Set<Product> products = new HashSet<>();
    private static Map<String, List<Product>> mapProducts = new HashMap<>();

    public static void main(String... args) {
        initProducts();

        mapProducts = toMapProducts(products);

        info();
    }

    public static void initProducts() {
        Product product1 = new Product("Ноутбук", "Электроника");
        Product product2 = new Product("Смартфон", "Электроника");
        Product product3 = new Product("Кофеварка", "Бытовая техника");
        Product product4 = new Product("Беговые кроссовки", "Обувь");
        Product product5 = new Product("Рюкзак", "Аксессуары");
        Product product6 = new Product("Цифровая камера", "Электроника");
        Product product7 = new Product("Тостер", "Бытовая техника");
        Product product8 = new Product("Часы", "Аксессуары");
        Product product9 = new Product("Игровая консоль", "Электроника");
        Product product10 = new Product("Туфли", "Обувь");

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);

        System.out.println("Товары поставлены\n");
    }

    public static Map<String, List<Product>> toMapProducts(Set<Product> products) {
        System.out.println("Продукты отсортированы\n");

        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    private static void info() {
        System.out.println("********************** INFO ********************************");

        for (Map.Entry<String, List<Product>> entry : mapProducts.entrySet()) {
            String category = entry.getKey();

            System.out.println("Категория: " + category);
            for (Product product : entry.getValue()) {
                System.out.println("\t" + product);
            }
            System.out.println();
        }

        System.out.println("*******************************************************************\n");
    }

}
