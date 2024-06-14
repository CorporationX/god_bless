package faang.school.godbless.task_011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) {

        // Создание продуктов
        int id = 0;
        products.add(new Product(++id, "Фасоль", "Консервы"));
        products.add(new Product(++id, "Горошек", "Консервы"));
        products.add(new Product(++id, "Тушонка", "Консервы"));
        products.add(new Product(++id, "Бананы", "Фрукты"));
        products.add(new Product(++id, "Апельсины", "Фрукты"));
        products.add(new Product(++id, "Яблоки", "Фрукты"));
        products.add(new Product(++id, "Печенье", "Кон. изделия"));
        products.add(new Product(++id, "Булочка", "Кон. изделия"));
        products.add(new Product(++id, "Вафли", "Кон. изделия"));

        // Группировка по категориям
        Map<String, List<Product>> groupByCategory = groupByCategory(products);

        // Вывод сгурппированных продуктов
        showGroupProducts(groupByCategory);

    }

    /**
     * Вывод сгруппированных товаров
     *
     * @param groupByCategory
     */
    private static void showGroupProducts(Map<String, List<Product>> groupByCategory) {
        for (var entry : groupByCategory.entrySet()) {
            System.out.println(entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("\t"+ product.name());
            }
        }
        System.out.println();
    }

    /**
     * Группировка товаров по категориям
     *
     * @param products
     * @return
     */
    private static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();

        for (Product p : products) {
            String category = p.category();
            if (result.containsKey(category)) {
                result.get(category).add(p);
            } else {
                result.put(category, new ArrayList<>(List.of(p)));
            }
        }

        return result;
    }
}
