package school.faang.sprint1task45166;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> productsList = new HashSet<>();

        Product pr1 = new Product(1, "apple 1", "vegetable 1");
        Product pr2 = new Product(2, "apple 2", "vegetable 1");
        Product pr3 = new Product(3, "apple 3", "vegetable 3");

        productsList.add(pr1);
        productsList.add(pr2);
        productsList.add(pr3);

        Wherehouse warehouse = new Wherehouse(3, productsList);
        warehouse.addItem("vegetable 4", "Armud");
        warehouse.addItem("vegetable 5", "Ciyelek");
        warehouse.removeItem("vegetable 3", "apple 3");
        warehouse.findItemsByCategory("vege");
        warehouse.printAllItems();
    }
}