package school.faang.sprint1.task_45165;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {

    private Map<String, List<Product>> productsByCategory;

    public ProductManager() {
        this.productsByCategory = new HashMap<>();
    }

    public void addItem(String category, String name) {
        if (!productsByCategory.containsKey(category)) {
            productsByCategory.put(category, new ArrayList<>());
        }
        int id = productsByCategory.get(category).size() + 1;
        Product newProduct = new Product(id, name, category);
        productsByCategory.get(category).add(newProduct);
        System.out.println("Товар " + name + " успешно добавлен в категорию " + category + ".");
    }

    public void removeItem(String category, String name) {
        if (productsByCategory.containsKey(category)) {
            List<Product> products = productsByCategory.get(category);
            Product productToRemove = null;
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    productToRemove = product;
                    break;
                }
            }
            if (productToRemove != null) {
                productsByCategory.remove(productToRemove);
                System.out.println("Удалено" + name + "категории" + category);
            } else {
                System.out.println("Товар с названием " + name + " не найден в категории " + category + ".");
            }
        } else {
            System.out.println("Категория " + category + " не найдена.");
        }
    }

    public void findItemsByCategory(String category) {
        if (productsByCategory.containsKey(category)) {
            List<Product> products = productsByCategory.get(category);
            System.out.println("Категория" + category);
            for (Product product : products) {
                System.out.println("Продукты" + product);
            }
        } else {
            System.out.println("Данной категории нет" + category);
        }
    }

    public void printAllItems() {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            String category = entry.getKey();
            List<Product> products = entry.getValue();
            System.out.println("Category: " + category);
            for (Product product : products) {
                System.out.println("  " + product);
            }
        }
    }
}



