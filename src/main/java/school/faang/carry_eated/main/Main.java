package school.faang.carry_eated.main;

import school.faang.carry_eated.main_code.InventoryService;

public class Main {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();

        service.combineAndAddToInventory().join();

        service.getInvertory().printAllItems();

        service.shutdown();
    }
}
