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

        for (int i = 0; i < character.getItems().size(); i++) {
            if (filter.test(character.getItems().get(i))) {
                character.getItems().set(i, action.apply(character.getItems().get(i)));
                break;
            }
        }
    }


}
