package school.faang.bjs270013;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character characterName,
                        Item itemName,
                        Consumer<Item> handler) {
        characterName.getItems().add(itemName);
        handler.accept(itemName);
    }

    public void removeItem(Character characterName,
                           Predicate<Item> predicate) {
        characterName.getItems().removeIf(predicate);
    }

    public void printInventory(Character characterName) {
        System.out.printf("%s Inventory\n", characterName.getName());
        for (Item item : characterName.getItems()) {
            System.out.printf("%s %s\n", item.getName(), item.getValue());
        }
    }

    public void updateItem(Character characterName,
                           Predicate<Item> predicate,
                           Function<Item, Item> updater) {
        List<Item> inventory = characterName.getItems();
        inventory.replaceAll(item ->
                predicate.test(item) ? updater.apply(item) : item);
    }
}