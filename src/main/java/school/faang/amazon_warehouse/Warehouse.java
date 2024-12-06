package school.faang.amazon_warehouse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Warehouse {
    private final Set<Product> products = new HashSet<>();

    public void addItem(String category, String name) {
        products.add(new Product(name, category));
    }

    public void printAllItems() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
