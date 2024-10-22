package LordOfRings;

import java.util.List;
import java.util.Objects;

public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name, List<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) && Objects.equals(inventory, character.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inventory);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
