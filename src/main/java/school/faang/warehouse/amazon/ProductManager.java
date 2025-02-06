package school.faang.warehouse.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int currentId = 1;

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                System.out.println("Такой товар уже присутствует в базе!");
                return;
            }
        }
        int id = currentId++;
        Product product = new Product(id, category, name);
        products.add(product);
        addProductInGroup(product, categoryMap);
        System.out.println("Добавлен товар - " + product);
    }

    public void removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                iterator.remove();
                categoryMap.get(category).remove(product);
                System.out.println("Удален товар - " + product);
                return;
            }
        }
        System.out.println("Товар такой категории не найден.");
    }

    public List<Product> findProductsByCategory(Category category) {
        if (categoryMap.containsKey(category)) {
            List<Product> list = categoryMap.get(category);
            list.forEach(System.out::println);
            return list;
        }
        System.out.println("Данной категории товаров не найдено.");
        return new ArrayList<>();
    }

    public void groupProductsByCategory() {
        Map<Category, List<Product>> map = new HashMap<>();
        for (Product product : products) {
            addProductInGroup(product, map);
        }
    }

    private void addProductInGroup(Product product, Map<Category, List<Product>> map) {
        map.computeIfAbsent(product.getCategory(), k -> new ArrayList<>());
        map.get(product.getCategory()).add(product);
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("\nКатегория: " + entry.getKey().toString() + "\nПродукты:");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
