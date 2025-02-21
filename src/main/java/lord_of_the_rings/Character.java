package lord_of_the_rings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private final String characterName;

    public Character(String characterName) {
        this.characterName = characterName;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
}