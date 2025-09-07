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

    void addProduct(Product.Category category, String name) {
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

    void removeProduct(Product.Category category, String name) {
        boolean removed = products.removeIf(product ->
                product.getName().equals(name) && product.getCategory().equals(category));

        if (removed) {
            System.out.println("\n[X] Удален предмет: " + name + ";\n"
                    + "Из категории - " + category);
        } else {
            System.out.println("\n[!] Товар '" + name + "' в категории " + category + " не найден");
        }
    }

    List<Product> findProductsByCategory(Product.Category category) {
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

        return new ArrayList<>(productListByCategory);
    }

    Map<Product.Category, List<Product>> groupProductByCategory() {
        Map<Product.Category, List<Product>> result = new HashMap<>();
        products.forEach(product -> {
            if (!result.containsKey(product.getCategory())) {
                result.put(product.getCategory(), new ArrayList<>());
            }
            result.get(product.getCategory()).add(product);
        });
        return result;
    }

    void printAllProducts() {
        Map<Product.Category, List<Product>> groupedProducts = groupProductByCategory();
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

        productManager.addProduct(Product.Category.FOOD, "Колбаса");
        productManager.addProduct(Product.Category.FOOD, "Молоко");
        productManager.addProduct(Product.Category.ELECTRONICS, "Смартфон");
        productManager.addProduct(Product.Category.CLOTHING, "Носки");
        productManager.addProduct(Product.Category.FOOD, "Сыр");
        productManager.addProduct(Product.Category.CLOTHING, "Штаны");
        productManager.addProduct(Product.Category.ELECTRONICS, "Телевизор");
        productManager.addProduct(Product.Category.CLOTHING, "Шапка");
        productManager.addProduct(Product.Category.OTHER, "Веник");

        productManager.printAllProducts();

        productManager.findProductsByCategory(Product.Category.CLOTHING);

        productManager.removeProduct(Product.Category.CLOTHING, "Штаны");
        productManager.removeProduct(Product.Category.FOOD, "Молоко");
        productManager.removeProduct(Product.Category.ELECTRONICS, "Смартфон");
        productManager.removeProduct(Product.Category.CLOTHING, "Шапка");

        productManager.findProductsByCategory(Product.Category.CLOTHING);
        productManager.findProductsByCategory(Product.Category.FOOD);

        productManager.printAllProducts();
    }
}
