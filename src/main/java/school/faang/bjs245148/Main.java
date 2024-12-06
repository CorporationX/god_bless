package school.faang.bjs245148;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addItem("Electronic", "Computer");
        manager.addItem("Electronic", "Mouse");
        manager.addItem("Electronic", "VideoCam");
        manager.addItem("Eating", "Apple");
        manager.addItem("Eating", "Burger");
        manager.addItem("Eating", "HotDog");

        manager.removeItem("Eating", "HotDog");
        manager.removeItem("Electronic", "Mouse");

        List<Product> electronic = manager.findItemsByCategory("Eating");

        for (Product product : electronic) {
            System.out.println(product.getId() + " - " + product.getCategory() + ":" + product.getName());
        }

        manager.printAllItems();
    }
}
