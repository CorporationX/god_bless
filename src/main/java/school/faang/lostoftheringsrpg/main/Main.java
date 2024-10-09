package school.faang.lostoftheringsrpg.main;

import school.faang.lostoftheringsrpg.main_code.Character;
import school.faang.lostoftheringsrpg.main_code.InventoryManager;
import school.faang.lostoftheringsrpg.main_code.Item;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("frodo");
        Item ring = new Item("ring", 100);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(ring, frodo,
                (item) -> System.out.println(item.getName() + " был добавлен"));

        inventoryManager.removeItem(frodo, (item) -> item.getName().equals("ring"));

        inventoryManager.addItem(ring, frodo,
                (item) -> System.out.println(item.getName() + " добавлен снова"));

        inventoryManager.updateItem(frodo, (item) -> item.getName().equals("ring"), 2000);

        frodo.getInventory().forEach(item -> {
            System.out.println(item.getName() + " " + item.getValue());
        });
    }
}
