package lordOfTheRings_811;

import lombok.Data;

import java.util.List;

@Data
public class Character {
    private List<Item> inventory;

    public Character(List<Item> inventory) {
        this.inventory = inventory;
    }
}