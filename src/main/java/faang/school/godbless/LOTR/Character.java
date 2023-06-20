package faang.school.godbless.LOTR;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private List<Item> inventory;

    public void addItem(Item item) {
        if (this.inventory == null) {
            this.inventory = new ArrayList<>();
        }
        this.inventory.add(item);
    }

    public void removeItem(Item item){
        if (this.inventory == null){
            throw new IllegalArgumentException("Empty inventory");
        }
        this.inventory.remove(item);
    }

    public void updateItem(Item item){

    }
}
