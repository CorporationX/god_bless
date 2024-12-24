package amazon_warehouse;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Set<Product> catalog = new HashSet<>();
    private static ProductSystem productSystem = new ProductSystem();

    public static void main(String[] args) {
        catalog.add(new Product("apple", "Fruits"));
        catalog.add(new Product("Carrot", "Vegetables"));
        catalog.add(new Product("Book", "hadow book"));
        productSystem.addItem("Book","shadow book",catalog);
        productSystem.addItem("book","fight book",catalog);
        productSystem.addItem("BoOk","Doom book",catalog);

        productSystem.addItem("Book", "dark book", catalog);
        productSystem.removeItem("Apple","Fruits",catalog);
        productSystem.findItemsByCategory("Book",catalog);
        productSystem.printAllItems(catalog);
        productSystem.groupProductsByCategory(catalog);

        productSystem.printProductsByCategory(productSystem.groupProductsByCategory(catalog));
    }
}
