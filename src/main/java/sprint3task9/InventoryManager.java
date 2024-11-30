package sprint3task9;

import lombok.Data;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class InventoryManager {
    public void addItem(Character character, Item item,
                        Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);

        //for (Item oddItem : character.getInventory()) {
        //if (predicate.test(oddItem)) {
        //character.getInventory().remove(oddItem);
        //   }
        // }
        //removeIf (убирает элемент, если тот проходит проверку на тесте предикатора)
        //remove () удаляет значение по index, либо первое соответствие из пары одинаковых элементов
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {
        for (Item removingItem : character.getInventory()) {
            if (predicate.test(removingItem)) {
                //function.apply(removingItem);
                //сверху неверно, тк обновляем айтем, но не сохраняем его, т.е. не кладем его на место старого айтема в листе инвентори.
                character.getInventory().set(character.getInventory().indexOf(removingItem), function.apply(removingItem));
//N
            }
        }
    }
    public static void main(String[] args) {
        Character frodo = new Character();
        Item ring = new Item("The One Ring", 1000);
        Item ring5 = new Item("The One Ring5", 10050);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, ring5, (item) ->
                System.out.println(item.getName() + " was added to the inventory."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) ->
                item.getName().equals("The One Ring"));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) ->
                item.getName().equals("The One Ring5"), (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory());
    }
}

//
//@FunctionalInterface
//public interface Consumer<T> {
//    void accept(T t);
//}
//
//@FunctionalInterface
//public interface Predicate<T> {
//    boolean test(T t);
//
//}
//@FunctionalInterface
//public interface Function<T, R> {
//    R apply(T t);
//}
