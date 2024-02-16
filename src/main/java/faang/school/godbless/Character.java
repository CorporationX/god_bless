package faang.school.godbless;

import java.util.List;

public class Character {
    private String name;
    private List<Item> inventory;

    public Character(List<Item> inventory, String name) {
        this.inventory = inventory;
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item){
        inventory.add(item);
    }

}
