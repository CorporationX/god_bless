package faang.school.godbless.lordoftherings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    private final List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }
}