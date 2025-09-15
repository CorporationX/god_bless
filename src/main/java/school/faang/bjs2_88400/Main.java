package school.faang.bjs2_88400;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Character legolas = new Character("Legolas", new ArrayList<>());

        inventoryManager.addItem(legolas, character -> {
            character.getInventory().add(new Item("Bow", 950, 1));
            System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            character.getInventory().get(character.getInventory().size() - 1).getName(),
                            character.getInventory().get(character.getInventory().size() - 1).getValue(),
                            character.getName());
        });
        inventoryManager.addItem(legolas, character -> {
            character.getInventory().add(new Item("Arrows", 400, 5));
            System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            character.getInventory().get(character.getInventory().size() - 1).getName(),
                            character.getInventory().get(character.getInventory().size() - 1).getValue(),
                            character.getName());
        });
        inventoryManager.addItem(legolas, character -> {
            character.getInventory().add(new Item("Cloak", 1200, 1));
            System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            character.getInventory().get(character.getInventory().size() - 1).getName(),
                            character.getInventory().get(character.getInventory().size() - 1).getValue(),
                            character.getName());
        });
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        inventoryManager.removeItem(legolas, item -> item.getAmount() == 0);
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        legolas.getInventory().get(1).setAmount(0);
        inventoryManager.removeItem(legolas, item -> item.getAmount() == 0);
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        inventoryManager.addItem(legolas, character -> {
            character.getInventory().add(new Item("Poison arrows", 500, 5));
            System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            character.getInventory().get(character.getInventory().size() - 1).getName(),
                            character.getInventory().get(character.getInventory().size() - 1).getValue(),
                            character.getName());
        });
        inventoryManager.addItem(legolas, character -> {
            character.getInventory().add(new Item("Fire arrows", 500, 5));
            System.out.printf("Предмет %s куплен за %d золота и добавлен в инвентарь %s%n",
                            character.getInventory().get(character.getInventory().size() - 1).getName(),
                            character.getInventory().get(character.getInventory().size() - 1).getValue(),
                            character.getName());
        });
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        inventoryManager.updateItem(legolas,
                item -> item.getName().contains("arrow"),
                item -> {
                    item.setAmount(item.getAmount() + 3);
                    return item;
                });
        legolas.getInventory().forEach(System.out::println);
        System.out.println("-----------------------------------------");

        inventoryManager.updateItem(legolas,
                item -> item.getValue() > 900,
                item -> {
                    item.setValue((int) (item.getValue() * 1.2));
                    return item;
                });
        legolas.getInventory().forEach(System.out::println);
    }
}
