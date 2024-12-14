package school.faang.task_45167;

import java.util.*;

public class ProductList {
        private static Map<String, Set<Product>> productMap = new HashMap<>();

        public static void addItem(String category, String name) {
            var product = new Product(category, name);
            if (!productMap.containsKey(category)) {
                productMap.put(category, new HashSet<>());
            }
            productMap.get(category).add(product);
        }

        public static void removeItem(String category, String name) {
            if (!productMap.containsKey(category)) {
                System.out.println("Категория '" + category + "' отсутствует.");
            }

            Set<Product> itemsInCategory = productMap.get(category);
            for (Product item : itemsInCategory) {
                if (item.getName().equals(name)) {
                    productMap.get(category).remove(item);
                } else {
                    System.out.println("Товар '" + name + "' отсутствует в категории '" + category + "'.");
                }
            }
        }

        public static void findItemsByCategory(String category) {
            if (!productMap.containsKey(category)) {
                System.out.println("Категория '" + category + "' не найдена.");
            }

            Set<Product> categoryItems = productMap.get(category);
            System.out.println("Товары в категории '" + category + "':");
            for (Product product : categoryItems) {
                System.out.println("- " + product);
            }
        }

        public static void printAllItems() {
            for (Map.Entry<String, Set<Product>> entry : productMap.entrySet()) {
                Set<Product> categoryItems = entry.getValue();

                System.out.println("Категория: " + entry.getKey());
                for (Product product : categoryItems) {
                    System.out.println("\t- " + product);
                }
            }
        }

        public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
            Map<String, List<Product>> groupedProducts = new HashMap<>();

            for (Product product : products) {
                String category = product.getCategory();
                if (!groupedProducts.containsKey(category)) {
                    groupedProducts.put(category, new ArrayList<>());
                }
                groupedProducts.get(category).add(product);
            }

            return groupedProducts;
        }

        public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
            for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
                String category = entry.getKey();
                List<Product> productsInCategory = entry.getValue();

                System.out.println("Категория: " + category);
                for (Product product : productsInCategory) {
                    System.out.println("\t" + product.toString());
                }
            }
        }
}