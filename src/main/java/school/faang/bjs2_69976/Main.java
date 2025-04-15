package school.faang.bjs2_69976;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character character = new Character("NN", new ArrayList<>());
        character.getInventory().add(new Item("F4-E", 1));
        character.getInventory().add(new Item("F15-E", 2));
        character.getInventory().add(new Item("F16lotC", 3));
        character.getInventory().add(new Item("Mig21bis", 4));
        character.getInventory().add(new Item("Mig23ml", 5));
        Item f22 = new Item("F22", 1);
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(character, f22,
                item -> {
                    if (character.getInventory().contains(item)) {
                        System.out.printf("Item %s added to %s's Inventory.\n",
                                item.getName(), character.getName());
                    } else {
                        System.out.printf("Item %s not added to %s's Inventory.\n",
                                item.getName(), character.getName());
                    }
                });
        character.getInventory().forEach(System.out::println);

        inventoryManager.removeItem(character, f22, item -> f22.getName().equals(item.getName()));

        inventoryManager.updateItem(character,
                (item -> item.getName().equals("F15-E")),
                (item -> {
                    item.setPrice(9000);
                    return item;
                })
        );
        character.getInventory().stream().filter(item -> item.getPrice() == 9000).forEach(System.out::println);
    }
}
