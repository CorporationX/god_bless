package faang.school.godbless.lambda.task8RPG;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> printAfterAdd) {
        character.getInventory().add(item);
        printAfterAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> items = character.getInventory();
        // Через итератор
//        Iterator<Item> itemsIterator= items.iterator();

//        while (itemsIterator.hasNext()) {
//            Item item = itemsIterator.next();
//            if (predicate.test(item)) {
//                itemsIterator.remove();
//                System.out.println(item.getName() + " was deleted");
//            }
//        }

        items.removeIf(predicate.and(item -> {
            System.out.println(item.getName() + " was deleted");
            return true;
        }));

        //Для первого вхождение
//        for (Item item: items) {
//            if (predicate.test(item)) {
//                items.remove(item);
//                System.out.println(item.getName() + " was deleted");
//                break;
//            }
//        }

    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, function.apply(item));
                // break; если нужно для первого вхождения
            }
        }
    }
}
