package school.faang.amazon_warehouse;

import java.util.HashSet;
import java.util.Set;

public class Warehouse {
    private final Set<Product> products = new HashSet<>();

    public void addItem(String category, String name) {

    }

    public void printAllItems() {
        products.forEach(System.out::println);
    }
}
