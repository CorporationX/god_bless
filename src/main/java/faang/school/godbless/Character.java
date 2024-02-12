package faang.school.godbless;

import java.util.List;

public class Character {
    private List<Item> inventory;

    public Character(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item){
        inventory.add(item);
    }

}
