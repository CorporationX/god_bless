package Lord_of_the_Rings_RPG;

import java.util.List;

public class Character {
    private String name;
    private List<Item> inventory;

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
