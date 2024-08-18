package faang.school.godbless.BJS2_21300;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getItemsList().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getItemsList().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> updatedItems = character.getItemsList().stream()
                .map(item -> predicate.test(item) ? function.apply(item) : item)
                .collect(Collectors.toList());
        character.setItemsList(updatedItems);
    }

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (item) ->
                System.out.println(item.getName() + " was added to the inventory."));
        manager.updateItem(frodo, (item) ->
                item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(frodo);
        manager.removeItem(frodo, (item) ->
                item.getName().equals("The One Ring"));
    }
}
