package school.faang.task_45149;

import lombok.Getter;

import java.util.*;

public class WarehouseSystem {

    private final Map<String, List<Product>> productCategories = new HashMap<>();
    @Getter
    private HashSet<Product> products = new HashSet<>();

    public void addItem(String category, String name) {
        Product addToProduct = new Product(name, category);
        products.add(addToProduct);
        productCategories.computeIfAbsent(category, k -> new ArrayList<>()).add(addToProduct);
        System.out.println("Товар: " + addToProduct + " добавлен!!!");
    }

    public void removeItem(String category, String name) {
        List<Product> productList = productCategories.get(category);
        if (productList != null) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    iterator.remove();
                    products.remove(product);
                    System.out.println("Товар: " + product + " удален!!!");
                    return;
                }
            }
            System.out.println("Товар с названием: " + name + " не найден!!!");
        } else {
            System.out.println("Категория не найдена!!!");
        }
    }

    public void findItemsByCategory(String category) {
        if (productCategories.get(category) != null) {
            List<Product> productList = productCategories.get(category);
            if (!productList.isEmpty()) {
                System.out.println("Категория: " + category);
                for (Product product : productList) {
                    System.out.println(product);
                }
                System.out.println();
            } else {
                System.out.println("Категория " + category + " пуста!!!\n");
            }
        } else {
            System.out.println("Категория " + category + " не найдена!!!");
        }
    }

    public void printAllItems() {
        System.out.println("\nВсе товары:\n" + productCategories.values() + "\n");
    }

}
