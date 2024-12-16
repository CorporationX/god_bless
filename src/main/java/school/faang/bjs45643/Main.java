package school.faang.bjs45643;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Character character = new Character(new ArrayList<>());
        Item item = new Item("Knife", 15);

        manager.addItem(character, item, null);

        manager.updateItem(character, (item1) -> item1.getName().equals("Knife"),
                (item1) -> new Item("Knife", item1.getValue() * 2));

        System.out.println(character.getInventory());
    }
}
