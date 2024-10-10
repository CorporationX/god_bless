package school.faang.sprint2.loardoftheeings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        Item rawItem = null;
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                rawItem = item;
                break;
            }
        }
        if (rawItem == null) {
            System.out.println("предмет не найдино");
            return;
        }
        character.getInventory().remove(rawItem);
        System.out.println("Предмет" + rawItem.getName() + "был удален из инвентара" + character);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemUpdate) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (itemPredicate.test(item)) {
                inventory.set(i, itemUpdate.apply(item));
                break;
            }
        }
    }
}
