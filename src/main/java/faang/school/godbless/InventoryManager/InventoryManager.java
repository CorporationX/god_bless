package faang.school.godbless.InventoryManager;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        consumer.accept(item);
        character.addInventory(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.removeItem(item);
                return;
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        int index = 0;
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.updateItem(index, function.apply(item));
            }
            index++;
        }
    }

    public void printCharacter(String text, Character character) {
        character.getInventory().
                forEach(item -> System.out.println(character.getName() + "= " + item.getName() + ": " + item.getValue()));
        System.out.println(text + "\n");
    }

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item bowAndArrow = new Item("Bow and arrow", 3000);
        Item sword = new Item("Sword", 3500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, bowAndArrow, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        System.out.println();
        manager.printCharacter("инвентарь персонажа после добавления предметов", frodo);

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.removeItem(frodo, (item) -> item.getName().equals("Bow and arrow"));
        manager.printCharacter("инвентарь персонажа после удалния предметов", frodo);

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        manager.updateItem(frodo, (item) -> item.getName().equals("Sword"), (item) -> new Item(item.getName(), item.getValue() * 2));
        manager.printCharacter("инвентарь персонажа после удвоения стоимости предметов", frodo);
    }
}
