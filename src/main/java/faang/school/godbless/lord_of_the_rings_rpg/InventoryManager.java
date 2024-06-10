package faang.school.godbless.lord_of_the_rings_rpg;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(@NonNull Character character, @NonNull Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(@NonNull Character character, @NonNull Predicate<Item> itemPredicate, @NonNull Function<Item, Item> function) {
        character.getInventory().replaceAll(item -> (itemPredicate.test(item)) ? function.apply(item) : item);
    }

    public static void main(String[] args) {
        Item ring = new Item("Ring", 125);
        Character character = new Character("Character");
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(character, ring, (item) -> System.out.println(item.getName() + " successfully added to inventory"));
        inventoryManager.updateItem(character, (item -> item.getValue() > 100), (item -> new Item(item.getName(), item.getValue() + 500)));
        inventoryManager.removeItem(character, (item) -> item.getName().equals("Ring"));
    }
}
