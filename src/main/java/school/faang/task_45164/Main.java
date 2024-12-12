package school.faang.task_45164;

import java.util.*;

public class Main {
    public static final String PRODUCT_SUCCESSFULLY_ADDED = "Продукт '%s' добавлен в категорию '%s'.%n";
    public static final String PRODUCT_ALREADY_EXISTS = "Продукт '%s' уже существует в категории '%s'.%n";
    public static final String PRODUCT_REMOVED = "Продукт '%s' удален из категории '%s'.%n";
    public static final String PRODUCT_NOT_FOUND = "Продукт '%s' в категории '%s' не найден.%n";
    public static final String CATEGORY_NOT_FOUND = "Категория с названием: '%s' не найдена.%n";
    public static final String STORE_IS_EMPTY = "В магазине нет товаров";

    HashSet<Product> products = new HashSet<>();
    private int productId = 0;

    public static void main(String[] args) {

    }

    public void addItem(String category, String name) {
        Product newProduct = new Product(productId++, name, category);
        if (products.add(newProduct)) {
            System.out.printf(PRODUCT_SUCCESSFULLY_ADDED, name, category);
        } else {
            System.out.printf(PRODUCT_ALREADY_EXISTS, name, category);
        }
    }

    public void removeItem(String category, String name) {
        Product productToRemove = products.stream()
                .filter(product -> product.getCategory().equals(category) && product.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (Objects.nonNull(productToRemove)) {
            products.remove(productToRemove);
            System.out.printf(PRODUCT_REMOVED, name, category);
        } else {
            System.out.printf(PRODUCT_NOT_FOUND, name, category);
        }
    }

    public void findItemsByCategory(String category) {
        List<Product> productsByCategory = products.stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();

        if (productsByCategory.isEmpty()) {
            System.out.printf(CATEGORY_NOT_FOUND, category);
        } else {
            System.out.printf("Список всех товаров в по категории: %s  %n", category);
            productsByCategory.forEach(product -> System.out.printf("- %s%n", product.getName()));
        }
    }

    public void printAllItems() {
        if (products.isEmpty()) {
            System.out.println(STORE_IS_EMPTY);
        } else {
            Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
            groupedProducts.forEach((category, productsList) -> {
                System.out.printf("Категория: %s", category);
                productsList.forEach(product ->
                        System.out.printf("Продукт с названием: %s", product.getName()));

            });
        }
    }


    public HashMap<String, List<Product>> groupProductsByCategory(HashSet<Product> productHashSet) {
        HashMap<String, List<Product>> result = new HashMap<>();
        for (Product product : productHashSet) {
            String category = product.getCategory();
            result.computeIfAbsent(category, key -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> product : groupedProducts.entrySet()) {
            List<Product> productList = product.getValue().stream().toList();
            System.out.printf("Категория товаров: %s%n", product.getKey());
            productList.forEach(product1 -> System.out.printf("-%s", product1.getName()));
        }
    }
}