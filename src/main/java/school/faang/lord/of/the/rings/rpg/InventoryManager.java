package school.faang.lord.of.the.rings.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
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

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        if (inventory == null || filter == null || updater == null) {
            throw new IllegalArgumentException("Character and filter cannot be null");
        }
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }


    }

    public static void main(String[] args) {
        Character cail = Character.builder().name("Cail").inventory(new ArrayList<>()).build();
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
