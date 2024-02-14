package LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate::test);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        Item newItem;
        //перебираем все предметы в инвентаре
        for (Item item : character.getInventory()) {
            //если предмет удовлетворяет условию предиката
            if (predicate.test(item)) {
                //"Обновляем"
                newItem = function.apply(item);
                character.getInventory().remove(item);
                character.getInventory().add(newItem);
                break;
            }
        }
    }
}
