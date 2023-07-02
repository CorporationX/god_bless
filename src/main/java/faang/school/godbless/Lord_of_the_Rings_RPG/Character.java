package faang.school.godbless.Lord_of_the_Rings_RPG;

public class Character {
    private final String name;
    private Item inventory;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Item getInventory() {
        return inventory;
    }

    public void setInventory(Item inventory) {
        this.inventory = inventory;
    }
}

