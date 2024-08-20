package faang.school.godbless.rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null) {
            System.out.println("Ты не пройдееешь! Объект не может быть null!");
        } else {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        if (character == null) {
            System.out.println("Ты не пройдееешь! Объект не может быть null!");
        } else {
            character.getInventory().removeIf(itemPredicate);
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        if (character == null) {
            System.out.println("Ты не пройдееешь! Объект не может быть null!");
        } else {
            for (int i = 0; i < character.getInventory().size(); i++) {
                Item currentItem = character.getInventory().get(i);
                if (itemPredicate.test(currentItem)) {
                    character.getInventory().set(i, itemFunction.apply(currentItem));
                }
            }
        }
    }
}
