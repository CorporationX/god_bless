package faang.school.godbless.rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer){
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> exists){
        character.getInventory().removeIf(exists);
    }
    public void updateItem(Character character, Predicate<Item> exists, Function<Item, Item> update){
        character.getInventory().forEach(item -> {
            if (exists.test(item)){
                update.apply(item);
                System.out.println("The item is updated");
            }
        });
    }
}
