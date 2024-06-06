package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Кофе", "Напитки"));
        products.add(new Product(2, "Чай", "Напитки"));
        products.add(new Product(3, "Хлеб", "Выпечка"));
        products.add(new Product(4, "Круассан", "Выпечка"));
        products.add(new Product(5, "Торт", "Выпечка"));

        Map<String, List<Product>> categoryProductGroups = groupCategoryProducts(products);
        showCategoryProducts(categoryProductGroups);

    }

    public static Map<String, List<Product>> groupCategoryProducts(Set<Product> products) {
        Map<String, List<Product>> categoryProductGroups = new HashMap<>();
        for (Product product : products) {
            if (!categoryProductGroups.containsKey(product.category())) {
                categoryProductGroups.put(product.category(), new ArrayList<>(List.of(product)));
            } else {
                categoryProductGroups.get(product.category()).add(product);
            }
        }

        return categoryProductGroups;
    }

    public static void showCategoryProducts(Map<String, List<Product>> categoryProducts) {
        System.out.println("Вывод категорий продуктов");
        for (Map.Entry<String, List<Product>> categoryProduct : categoryProducts.entrySet()) {
            System.out.println("Категория " + categoryProduct.getKey() + " - товары:");
            for (Product product : categoryProduct.getValue()) {
                System.out.println('\t' + "Продукт: " + product);
            }
        }
    }
}
