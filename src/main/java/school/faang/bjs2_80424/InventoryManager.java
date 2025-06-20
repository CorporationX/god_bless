package school.faang.bjs2_80424;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        isEmptyInventory(character.getInventory());
        itemConsumer.accept(item);
        character.addItem(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        isEmptyInventory(character.getInventory());

        List<Item> items = new ArrayList<>();
        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                continue;
            }
            items.add(item);
        }
        character.setInventory(items);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> consumer) {
        isEmptyInventory(character.getInventory());

        List<Item> items = new ArrayList<>();
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                Item itemConsumer = consumer.apply(item);
                items.add(itemConsumer);
                continue;
            }
            items.add(item);
        }
        character.setInventory(items);
    }

    private void isEmptyInventory(List<Item> inventory) {
        if (inventory == null || inventory.isEmpty()) {
            log.info("В инвентаре ничего нет или не может быть null");
            return;
        }
    }
}
