package school.faang.sprint_2.lord_of_the_rings_rpg;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item) {
        character.getInventory().add(item);
        log.info("Item {} added to the {} inventory", item.getName(), character.getName());
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Consumer<Item> consumer) {
        character.getInventory().stream().filter(predicate).forEach(consumer);
    }
}
