package school.faang.sprint_1.task_bjs245200;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addItem("Electronics", "smartphone");
        store.addItem("Electronics", "laptop");
        store.addItem("Clothing", "shirt");

        store.printAllItems();

        List<Product> electronics = store.findItemsByCategory("Electronics");
        System.out.println("Electronics: " + electronics);
        store.removeItem("Electronics", "smartphone");
        HashSet<Product> products = new HashSet<>(store.findItemsByCategory("Electronics"));
        Map<String, List<Product>> grouped = store.groupProductsByCategory(products);
        store.printProductsByCategory(grouped);
    }
}
