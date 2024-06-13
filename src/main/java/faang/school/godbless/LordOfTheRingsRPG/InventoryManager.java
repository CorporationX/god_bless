package faang.school.godbless.LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> applyMessage) {
        if (!character.getInventory().contains(item)) {
            character.getInventory().add(item);
            applyMessage.accept(item);
        } else {
            System.out.println(item + " is already exists");
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(item -> !condition.test(item));
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> update) {
        //character.getInventory().removeIf(item -> !condition.test(item));

        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                update.apply(item);
                character.getInventory().remove(item);
                break;
            }
        }
    }


}