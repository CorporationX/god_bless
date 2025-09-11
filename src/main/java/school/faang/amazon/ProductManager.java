package school.faang.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products;

    public ProductManager() {
        products = new HashSet<>();
    }

    //Добавляем продукт
    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
    }

    //Удаляем продукт
    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory() == category && product.getName().equals(name));
    }

    //Поиск продуктов по категории
    public List<Product> findProductsByCategory(Category category) {
        List<Product> productsList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                productsList.add(product);
            }
        }
        return productsList;
    }

    //Группировка по категориям
    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            groupedProducts
                    .computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
        }
        return groupedProducts;
    }

    //Выводим список всех продуктов, сгрупированных по категориям
    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        for (Category category : groupedProducts.keySet()) {
            System.out.printf("Категория: %s%n", category);
            System.out.println("Продукты:");
            for (Product product : groupedProducts.get(category)) {
                System.out.printf("- %s%n", product.getName());
            }
            System.out.println();
        }
    }
}
