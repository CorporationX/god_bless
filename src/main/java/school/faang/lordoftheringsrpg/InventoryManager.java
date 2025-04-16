package school.faang.lordoftheringsrpg;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
@AllArgsConstructor
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> afterAddAction) {
        if (afterAddAction == null) {
            throw new IllegalArgumentException("afterAddAction is null!");
        }
        Optional.ofNullable(character.getInventory())
                .ifPresentOrElse(
                        inventory -> {
                            inventory.add(item);
                            afterAddAction.accept(item);
                        },
                        () -> log.info("Inventory is null"));
    }

    public void removeItem(Character character, Predicate<Item> removeCondition) {
        if (removeCondition == null) {
            throw new IllegalArgumentException("removeCondition is null!");
        }
        Optional.ofNullable(character.getInventory())
                .ifPresentOrElse(
                        inventory -> inventory.removeIf(removeCondition),
                        () -> log.info("Inventory is null"));

    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transformItem) {
        Optional.ofNullable(character.getInventory())
                .ifPresentOrElse(
                        inventory -> inventory.replaceAll(item -> filter.test(item) ? transformItem.apply(item) : item),
                        () -> log.info("Inventory is null"));
    }
}
