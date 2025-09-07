package school.faang.bjs2_86222;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class ProductManager {

    private final Set<Product> products;

    public ProductManager() {
        this.products = new HashSet<>();
    }

    public boolean addProduct(Category category, String name) {
        validateCategory(category);
        validateName(name);

        Product product = new Product(name, category);
        if (products.contains(product)) {
            System.out.println("Продукт уже есть на складе.");
            return false;
        }
        products.add(product);
        System.out.println("Продукт " + product.getName() + " добавлен на склад.");
        return true;
    }

    public boolean removeProduct(Category category, String name) {
        validateCategory(category);
        validateName(name);

        Product product = new Product(name, category);
        if (!products.contains(product)) {
            System.out.println("Такого продукта нет на складе.");
            return false;
        }
        products.remove(product);
        System.out.println("Продукт " + product.getName() + " удалён со склада.");
        return true;
    }

    public List<Product> findProductsByCategory(Category category) {
        validateCategory(category);
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            result.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> map = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : map.entrySet()) {
            System.out.printf("Категория: %s%nПродукты:%n", entry.getKey());
            for (Product product : map.get(entry.getKey())) {
                System.out.printf("- %s%n", product.getName());
            }
            System.out.println();
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null.");
        }
    }

    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Категория не может быть null.");
        }
    }
}
