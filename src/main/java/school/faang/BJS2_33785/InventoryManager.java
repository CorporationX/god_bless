package school.faang.BJS2_33785;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        System.out.println(item.getName() + " добавлен в инвентарь");
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
        System.out.println("Предметы, удовлетворяющие условию удалены");
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        character.getInventory().replaceAll(item -> condition.test(item) ? updateFunction.apply(item) : item);
        System.out.println("Предметы, удовлетворяющие условию обновлены");
    }
}
