package school.faang.task_45496;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
public class InventoryManager {
    private Character character;

    public void addItem(Character character, Item item, Consumer<Item> itemPredicate){
        List<Item> listItem = character.getInventory();
        listItem.add(item);
        character.setInventory(listItem);
        itemPredicate.accept(item);
    }

    public void removeItem(Character character, Item item, Predicate<Item> itemPredicate){

    }

    public void updateItem(Character character, Item item){
    }
}
