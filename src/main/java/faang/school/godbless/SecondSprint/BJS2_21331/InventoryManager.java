package faang.school.godbless.SecondSprint.BJS2_21331;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {


    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character frodo, Predicate<Item> predicate) {
        List<Item> list = frodo.getInventory();
        for (int i = 0; i < list.size(); i++){
            if (predicate.test(list.get(i))){
                list.remove(i);
            }
        }

    }

    public void updateItem(Character frodo, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> list = frodo.getInventory();
        for (int i = 0; i < list.size(); i++){
            if (predicate.test(list.get(i))){
               list.add( i , function.apply(list.get(i)));
               list.remove(i + 1);
            }
        }
    }
}
