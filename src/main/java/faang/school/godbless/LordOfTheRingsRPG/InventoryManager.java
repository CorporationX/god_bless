package faang.school.godbless.LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character.getInventory().removeIf(predicate))
            System.out.println("Предмет удален");
        else
            System.out.println("Такого предмета не обнаружено");
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                item = function.apply(item);
                System.out.println("Предмет " + item.toString() + " изменен");
            }
        }
    }
}
