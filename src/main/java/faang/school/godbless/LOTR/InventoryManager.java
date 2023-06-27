package faang.school.godbless.LOTR;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        for (int i = 0; i< character.getInventory().size(); i++){
            character.getInventory().removeIf(itemPredicate);
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (itemPredicate.test(character.getInventory().get(i))){
                character.getInventory().set(i, itemFunction.apply(character.getInventory().get(i)));
            }
        }
    }
}
