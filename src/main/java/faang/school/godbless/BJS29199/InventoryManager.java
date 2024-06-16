package faang.school.godbless.BJS29199;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character.getInventory().contains(item)) {
            System.out.println("Item " + item.getName() + " already exists in the "
                    + character.getName() + "'s inventory");
        } else {
            character.getInventory().add(item);
            System.out.println("Item " + item.getName() + " added successfully to "
                    + character.getName() + "'s inventory");
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Item item, Predicate<Item> predicate) {
        boolean removed = character.getInventory().removeIf(predicate);

        if (removed) {
            System.out.println("Item " + item.getName() + " removed successfully from "
                    + character.getName() + "'s inventory");
        } else {
            System.out.println("No matching item " + item.getName() + " found in "
                    + character.getName() + "'s inventory with this predicate");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> updatedItems = character.getInventory().stream()
                .map(item -> predicate.test(item) ? function.apply(item) : item)
                .collect(Collectors.toList());
        character.setInventory(updatedItems);
        System.out.println(character.getName() + "'s inventory successfully updated");
    }

    public void printInventory(Character character) {
        System.out.println("\nStart printing " + character.getName() + "'s inventory");
        character.getInventory().forEach(System.out::println);
        System.out.println("Finish printing " + character.getName() + "'s inventory\n");
    }
}
