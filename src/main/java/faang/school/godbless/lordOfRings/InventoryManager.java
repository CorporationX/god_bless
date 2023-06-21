package faang.school.godbless.lordOfRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> adder){
        character.addItemToInventory(item);
    }

    public void removeItem(Character character,Predicate<Item> condition){
         character.getInventory().stream().filter(condition::test)
                 .forEach(item -> item.setValue(0));
    }

    public void updateItem(Character character, Predicate<Item> condition,
                           Function<Item, Item> update){
        character.setInventory(character.getInventory().stream()
                .filter(condition)
                .map(update::apply)
                .collect(Collectors.toList()));
    }
}
