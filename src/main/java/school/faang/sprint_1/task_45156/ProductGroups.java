package school.faang.sprint_1.task_45156;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductGroups {
    private final Map<String, List<Product>> groupedProducts;

    public ProductGroups(Map<String, List<Product>> groupedProducts) {
        this.groupedProducts = groupedProducts;
    }
    public void addItem(String category, String name) {
        Product product = new Product(name, category);
        groupedProducts.computeIfAbsent(category, k ->  new ArrayList<>()).add(product);
        System.out.println("Добавлен товар " + product + "\n");
    }

    public void removeItem(String category, String name) {
        List<Product> listProducts = groupedProducts.get(category);
        if (listProducts == null) {
            System.out.println("Категории " + category + " не существует\n");
        } else {
            boolean result = listProducts.remove(new Product(name, category));
            if (result) {
                System.out.println(MessageFormat.format("Удалён товар {0} из категории {1}\n", name, category));
                if (listProducts.isEmpty()) {
                    groupedProducts.remove(category);
                }
            }
            else {
                System.out.println("Товара " + name + " не существует\n");
            }
        }
    }

    public void findItemsByCategory(String category) {
        List<Product> listProducts = groupedProducts.get(category);

        if (listProducts == null) {
            System.out.println(MessageFormat.format("Категория {0} не найдена", category));
        } else {
            System.out.println("Найдены товары в категории: " + category);
            for (Product product : listProducts) {
                System.out.println("\t" + product);
            }
            System.out.println();
        }
    }

    public void printAllItems() {
        groupedProducts.forEach((category, listProducts)->{
            System.out.println("Категория: " + category);
            for (Product product : listProducts) {
                System.out.println("\t" + product);
            }
            System.out.println();
        });
    }
}
