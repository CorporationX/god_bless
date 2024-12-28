package lord_of_the_rings_RPG;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Item item, List<Item> itemList, Consumer<Item> consumer) {
        itemList.add(item);
        consumer.accept(item);
    }

    public void removeItem(List<Item> itemList, Predicate<Item> predicate) {
        if (itemList.removeIf(predicate)) {
            System.out.println("Предмет удален из инвентаря");
        } else {
            System.out.println("Предмет не найден в инвентаре");
        }
    }

    public void updateItem(List<Item> itemList, Consumer<Item> consumer, Predicate<Item> predicate) {
        itemList.stream()
                .filter(predicate)
                .forEach(consumer);
        System.out.println("Такого предмета в инвентаре!");
    }
}