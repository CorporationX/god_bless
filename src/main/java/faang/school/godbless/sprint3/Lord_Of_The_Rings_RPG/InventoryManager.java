package faang.school.godbless.sprint3.Lord_Of_The_Rings_RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer consumer) {
        character.setInventory(item, (a) -> character.getInventory().add((Item) a));
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) throws Exception {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item tmp = character.getInventory().get(i);
            if (predicate.test(tmp)) {
                character.setInventory(tmp, (a) -> character.getInventory().remove(a));
                return;
            }
        }
        throw new Exception("Item is not was found, item is not be removed");

    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) throws Exception {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item tmp = character.getInventory().get(i);
            if (predicate.test(tmp)) {
                character.getInventory().set(i,function.apply(tmp));
                return;
            }
        }
        throw new Exception("Item is not was found, item is not be updated");
    }
}
