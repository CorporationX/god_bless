package lord.of.the.rings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        for (Item item: character.getInventory()) {
            if (itemPredicate.test(item)) {
                System.out.printf("Предмет '%s' был удалён из инвенторя", item.getName()).println();
                return;
            }
        }

        System.out.println("Предмет не был найден");
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (itemPredicate.test(item)) {
                inventory.set(i, itemFunction.apply(item));
                return;
            }
        }

        System.out.println("Предмет не был найден");
    }

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }
}
