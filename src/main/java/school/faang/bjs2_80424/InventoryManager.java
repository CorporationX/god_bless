package school.faang.bjs2_80424;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        itemConsumer.accept(item);
        List<Item> items = new ArrayList<>();
        items.add(item);
        if (character.getInventory() != null) {
            for (Item weapon : character.getInventory()) {
                items.add(weapon);
            }
        }
        character.setInventory(items);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        if (character.getInventory() == null) {
            System.out.println("В инвентаре ничего нет");
            return;
        }

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
        if (character.getInventory() == null) {
            System.out.println("В инвентаре ничего нет");
            return;
        }

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
}
