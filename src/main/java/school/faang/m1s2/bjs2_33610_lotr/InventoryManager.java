package school.faang.m1s2.bjs2_33610_lotr;

import lombok.Data;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Data
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> message) {
        character.getInventory().add(item);
        message.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> isExists) {
        character.getInventory().removeIf(isExists);
    }

    public void updateItem(Character character, Predicate<Item> isExists, Consumer<Item> modifier) {
        Set<Item> inventory = character.getInventory();
        for (Item item : inventory) {
            if (isExists.test(item)) {
                modifier.accept(item);
            }
        }
    }
}
