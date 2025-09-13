package school.faang.bjs2_88400;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Character legolas = new Character("Legolas", new ArrayList<>());

        inventoryManager.addItem(legolas,
                new Item("Bow", 950, 1),
                (character, item) -> {
                    character.getInventory().add(item);
                    System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            item.getName(), item.getValue(), character.getName());
                });
        inventoryManager.addItem(legolas,
                new Item("Arrows", 400, 5),
                (character, item) -> {
                    character.getInventory().add(item);
                    System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            item.getName(), item.getValue(), character.getName());
                });
        inventoryManager.addItem(legolas,
                new Item("Cloak", 1200, 1),
                (character, item) -> {
                    character.getInventory().add(item);
                    System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            item.getName(), item.getValue(), character.getName());
                });
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        inventoryManager.removeItem(legolas, item -> item.getAmount() != 0);
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        legolas.getInventory().get(1).setAmount(0);
        inventoryManager.removeItem(legolas, item -> item.getAmount() != 0);
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        inventoryManager.addItem(legolas,
                new Item("Poison arrows", 500, 5),
                (character, item) -> {
                    character.getInventory().add(item);
                    System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            item.getName(), item.getValue(), character.getName());
                });
        inventoryManager.addItem(legolas,
                new Item("Fire arrows", 500, 5),
                (character, item) -> {
                    character.getInventory().add(item);
                    System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            item.getName(), item.getValue(), character.getName());
                });
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        inventoryManager.updateItem(legolas,
                item -> item.getName().contains("arrow"),
                item -> item.getAmount() + 3);
        legolas.getInventory().forEach(System.out::println);
    }
}
