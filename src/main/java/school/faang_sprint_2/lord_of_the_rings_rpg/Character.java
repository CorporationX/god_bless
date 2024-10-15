package school.faang_sprint_2.lord_of_the_rings_rpg;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Data
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void addItem(Item item, Character character, Consumer<Item> consumer) {
        consumer.accept(item);
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);

    }
}
