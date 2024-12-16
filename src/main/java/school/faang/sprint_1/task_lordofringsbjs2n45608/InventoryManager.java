package school.faang.sprint_1.task_lordofringsbjs2n45608;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryManager {

    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> consumer) {
        character.addItem(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character != null && predicate != null) {
            character.getInventory().removeIf(predicate::test);
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character != null
                && predicate != null
                && function != null) {

            for (int i = 0; i < character.getInventory().size(); i++) {
                if (predicate.test(character.getInventory().get(i))) {
                    character.getInventory().set(i,
                            function.apply(character.getInventory().get(i)));
                }
            }
        }
    }
}
