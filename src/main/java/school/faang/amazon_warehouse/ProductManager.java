package school.faang.amazon_warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Integer currentId = 1;
    Set<Product> products = new HashSet<>();

    void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("[!] Товар с таким именем уже существует в категории " + category);
                return;
            }
        }
        Product product = new Product(currentId++, name, category);
        products.add(product);
        System.out.println("[+] Добавлен товар: " + product);
    }

    void removeProduct(Category category, String name) {
        boolean removed = products.removeIf(product ->
                product.getName().equals(name) && product.getCategory().equals(category));

        if (removed) {
            System.out.println("\n[X] Удален предмет: " + name + ";\n"
                    + "Из категории - " + category);
        } else {
            System.out.println("\n[!] Товар '" + name + "' в категории " + category + " не найден");
        }
    }

    List<Product> findProductsByCategory(Category category) {
        List<Product> productListByCategory = products.stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();

        System.out.println();
        if (productListByCategory.isEmpty()) {
            System.out.println("[!] В категории " + category + " товаров не найдено");
        } else {
            System.out.println("[*] Товары в категории " + category + ":");
            for (int i = 0; i < productListByCategory.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + productListByCategory.get(i));
            }
        }

        return productListByCategory;
    }

    Map<Category, List<Product>> groupProductByCategory() {
        Map<Category, List<Product>> result = new HashMap<>();
        products.forEach(product -> {
            if (!result.containsKey(product.getCategory())) {
                result.put(product.getCategory(), new ArrayList<>());
            }
            result.get(product.getCategory()).add(product);
        });
        return result;
    }

    void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductByCategory();
        System.out.println();
        groupedProducts.forEach((category, products) -> {
            System.out.println("\nКатегория: " + category);
            System.out.println("Продукты:");
            for (Product product : products) {
                System.out.println("  - " + product.getName());
            }
        });
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        System.out.println();

        productManager.addProduct(Category.FOOD, "Колбаса");
        productManager.addProduct(Category.FOOD, "Молоко");
        productManager.addProduct(Category.ELECTRONICS, "Смартфон");
        productManager.addProduct(Category.CLOTHING, "Носки");
        productManager.addProduct(Category.FOOD, "Сыр");
        productManager.addProduct(Category.CLOTHING, "Штаны");
        productManager.addProduct(Category.ELECTRONICS, "Телевизор");
        productManager.addProduct(Category.CLOTHING, "Шапка");
        productManager.addProduct(Category.OTHER, "Веник");

        productManager.printAllProducts();

        productManager.findProductsByCategory(Category.CLOTHING);

        productManager.removeProduct(Category.CLOTHING, "Штаны");
        productManager.removeProduct(Category.FOOD, "Молоко");
        productManager.removeProduct(Category.ELECTRONICS, "Смартфон");
        productManager.removeProduct(Category.CLOTHING, "Шапка");

        productManager.findProductsByCategory(Category.CLOTHING);
        productManager.findProductsByCategory(Category.FOOD);

        productManager.printAllProducts();
    }
}
