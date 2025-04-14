package school.faang.lord_of_rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> actionMaker) {
        character.getInventory().add(item);
        actionMaker.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemFilter) {
        boolean wasItemRemoved = character.getInventory().removeIf(itemFilter);
        if (wasItemRemoved) {
            System.out.println("Inventory was updated, removal completed as per the filter");
        }
    }

    public void updateItem(Character character, Function<Item, Item> transformer) {
        character.getInventory().stream().map(transformer).toList();
        /*character.getInventory().forEach(transformer::apply);
        тут вот не знаю насколько нормально использовать forEach в таком ключе.
        Как будто вариант с map более очевидный, поскольку из самого метода map понятно, что здесь как-то будут
        модифицироваться объекты стрима, в forEach же надо смотреть сам метод, то ли мы хотим что-то распечатать,
        то ли обновляем поле как в этом случае.
         */
    }
}
