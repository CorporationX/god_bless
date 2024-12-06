package school.faang.amazon_warehouse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addItem("cat1", "pr1");
        warehouse.addItem("cat2", "pr2");
        warehouse.addItem("cat1", "pr3");
        warehouse.addItem("cat3", "pr4");

        warehouse.printAllItems();
    }
}
