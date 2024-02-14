package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private List<Item> inventory;
    Character(String name){
        this.name = name;
        this.inventory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }



    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
