package lordOfTheRingRpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                character.removeItem(item);
                System.out.println("Предмет " + item.getName() + " был удалён из инвентаря персонажа " + character.getName());
                break;
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemUpdateValue) {
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                Item itemToUpdate = itemUpdateValue.apply(item);
                character.removeItem(item);
                character.addItem(itemToUpdate);
                break;
            }
        }
    }
}
