package school.BJS2_33604;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getItems().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getItems().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> action) {

        //Был вариант так сделать
//        for (Item item : character.getItems()) {
//            if(filter.test(item)) {
//                int index = character.getItems().indexOf(item);
//                character.getItems().set(index,action.apply(item));
//            }
//        }
        character.setItems(character.getItems().parallelStream().map(x -> {
            if (filter.test(x)) {
                x = action.apply(x);
            }
            return x;
        }).collect(Collectors.toList()));
    }


}
