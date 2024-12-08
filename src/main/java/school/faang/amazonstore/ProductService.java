package school.faang.amazonstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private Map<String, List<String>> products = new HashMap<>();

    public void addItem(String category, String name) {
        products.computeIfAbsent(category, k -> new ArrayList<>()).add(name);
    }

    public void removeItem(String category, String name) {
        if (products.containsKey(category)) {
            List<String> groupedProducts = products.get(category);
            if (groupedProducts.contains(name)) {
                groupedProducts.remove(name);
            } else {
                System.out.printf("Не удалось удалить %s, его нет в категории %s \n", name, category);
            }
        } else {
            System.out.printf("Не удалось удалить %s, категории %s не существует \n", name, category);
        }
    }

    public void findItemsByCategory(String category) {
        if (products.containsKey(category)) {
            System.out.println(products.get(category));
        } else {
            System.out.println("Упс, такой категории не существует :(");
        }
    }

    public void printAllItems() {
        for (Map.Entry<String, List<String>> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
