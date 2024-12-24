package amazon_warehouse;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductSystem {

    public void addItem(String category, String name, Set<Product> products) {

        Product product = new Product(name, category.toLowerCase());
        if (products.contains(product)) {
            throw new IllegalArgumentException("Такой товар уже есть в системе!");
        }
        products.add(product);

        if (!products.contains(product)) {
            throw new IllegalStateException("Товар не добавился в каталог!");
        }
        System.out.println("Товар добавлен в каталог");
    }

    public void removeItem(String category, String name, Set<Product> products) {
        validateIsBlank(category, name);
        Product product = new Product(name,category);
        if (!products.contains(product)) {
            throw new IllegalStateException("Невозможно удалить товар: такого товара не существует!");
        }
        products.remove(product);
        if (products.contains(product)) {
            throw new IllegalStateException("Товар не удален из каталога!");
        }
    }

    public void findItemsByCategory(String category, Set<Product> products) {
        if (category.isBlank()) {
            throw new IllegalArgumentException("поле не может быть пустым!");
        }
        if (products.stream().noneMatch(product -> product.getCategory().equalsIgnoreCase(category))) {
            throw new IllegalArgumentException("Нет такой категории товара: " + category);
        }
        Set<Product> filterProduct = products.stream()
                .filter(e -> category.equalsIgnoreCase(e.getCategory().trim()))
                .collect(Collectors.toSet());
        filterProduct.forEach(System.out::println);
    }

    public void printAllItems(Set<Product> products) {
        validatorSet(products);
        products.forEach(e ->
                System.out.println("Категория: " + e.getCategory() + ", имя товара: " + e.getName()));
    }


    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        validatorSet(products);
        Map<String, List<Product>> filterProduct = products.stream()
                .collect(Collectors.groupingBy(e -> e.getCategory().toLowerCase()));
        return filterProduct;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        if (groupedProducts.isEmpty()) {
            throw new IllegalArgumentException("список пуст");
        }
        groupedProducts.forEach((key, value) -> {
            System.out.println("Категория: " + key);
            value.forEach(product ->
                    System.out.println("  - " + product.getName() + " (ID: " + product.getId() + ")"));
        });
    }

    private static void validateIsBlank(String category, String name) {
        if (name.isBlank() || category.isBlank()) {
            throw new IllegalArgumentException("Поля не могут быть пустыми!");
        }
    }

    private static void validatorSet(Set<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("список пуст");
        }
    }
}
