package school.faang.sprint2.loardoftheeings;
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
        Item itemToUpdate = null;
        Item itemToDelete = null;
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                itemToDelete = item;
                itemToUpdate = itemUpdate.apply(item);
            }
        }
        character.getInventory().remove(itemToUpdate);
        character.getInventory().add(itemToDelete);
    }
}
