package school.faang.lord.of.the.rings.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    void removeItem(Character character, Predicate<Item> filter) {
        List<Item> inventory = character.getInventory();
        if (inventory == null || filter == null) {
            throw new IllegalArgumentException("Character and filter cannot be null");
        }
        inventory.removeIf(item -> {
            boolean matches = filter.test(item);
            if (matches) {
                System.out.println("[-] " + item.getName() + " удалён из инвентаря.");
            }
            return matches;
        });
    }

    void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        if (inventory == null || filter == null || updater == null) {
            throw new IllegalArgumentException("Character and filter cannot be null");
        }
        ListIterator<Item> iterator = inventory.listIterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (filter.test(item)) {
                Item updatedItem = updater.apply(item);
                iterator.set(updatedItem);
                System.out.println("[*] Предмет " + item.getName() + " обновлен: "
                        + item.getValue() + " -> " + updatedItem.getValue());
            }
        }


    }

    public static void main(String[] args) {
        Character cail = new Character("Cail", new ArrayList<>());
        Item staffOfMagic = new Item("Staff of magic", 1500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(cail, staffOfMagic,
                (item) -> System.out.println("[+] Добавлен новый предмет: " + item.getName()));
        manager.removeItem(cail, (item) -> item.getName().contains("Staff of"));

        manager.addItem(cail, staffOfMagic,
                (item -> System.out.println("[+] " + item.getName() + " снова добавлен в инвентарь")));
        manager.updateItem(cail, (item -> item.getName().contains("Staff of magic")),
                item -> new Item(item.getName(), item.getValue() * 3));

        cail.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
