package school.faang.m2_1_functional_interfaces.lord_of_the_rings_rpg;

import school.faang.m2_1_functional_interfaces.lord_of_the_rings_rpg.model.Character;
import school.faang.m2_1_functional_interfaces.lord_of_the_rings_rpg.model.Item;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(
            Character character,
            Predicate<Item> predicate,
            UnaryOperator<Item> operator
    ) {
        List<Item> inventory = character.getInventory();
        Item item = inventory.stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow();
        int index = inventory.indexOf(item);
        inventory.set(index, operator.apply(item));
    }
}
