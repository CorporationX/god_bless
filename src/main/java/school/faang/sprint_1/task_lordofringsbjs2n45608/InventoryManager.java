package school.faang.sprint_1.task_lordofringsbjs2n45608;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryManager {
    Logger inventaryLogger = LoggerFactory.getLogger("inventoryLogger");

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (Stream.of(character, item, consumer).allMatch(Objects::nonNull)) {
            character.addItem(item);
            consumer.accept(item);
        } else {
            inventaryLogger.warn("Some param(s) in addItem() is NULL");
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character != null && predicate != null) {
            // Можно замемнить на  character.getInventory().removeIf(predicate::test);
            Iterator<Item> iteratorItems = character.getInventory().iterator();
            while (iteratorItems.hasNext()) {
                if (predicate.test(iteratorItems.next())) {
                    iteratorItems.remove();
                }
            }
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
