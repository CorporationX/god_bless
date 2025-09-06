package school.faang.bjs2_86006;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Slf4j
public class ProductManager {
    Set<Product> products = new HashSet<>();
    private int nextId = 1;

    public Product addProduct(Category category, String name) {

        if (category == null) {
            throw new IllegalArgumentException("Категория не может быть null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        }
        Product newProduct = new Product(nextId++, name, category);

        if (products.add(newProduct)) {
            log.info("Продукт {} успешно добавлен с ID {}", name, newProduct.getId());
            return newProduct;
        } else {
            log.warn("Продукт {} уже добавлен", name);
            return null;
        }
    }

    public boolean removeProduct(Category category, String name) {

        if (category == null) {
            throw new IllegalArgumentException("Категория не может быть null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        }

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory() == category && product.getName().equals(name)) {
                iterator.remove();
                log.info("Продукт '{}' категории {} успешно удален", name, category);
                return true;
            }
        }
        log.warn("Продукт '{}' категории {} не найден для удаления", name, category);
        return false;
    }

    public List<Product> findProductsByCategory(Category category) {

        if (category == null) {
            return new ArrayList<>();
        }

        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> result = new HashMap<>();

        for (Product product : products) {
            Category category = product.getCategory();

            if (!result.containsKey(category)) {
                result.put(category, new ArrayList<>());
            }
            result.get(category).add(product);
        }
        return result;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            Category category = entry.getKey();
            List<Product> categoryProducts = entry.getValue();

            System.out.println("Категория: " + category);
            System.out.println("Продукты:");

            for (Product product : categoryProducts) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }

        if (groupedProducts.isEmpty()) {
            System.out.println("Продуктов не найдено.");
        }
    }
}