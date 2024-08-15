package faang.school.godbless.LordOfTheRingsRPG;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Character {
    private List<Item> inventory = new ArrayList<>();

    public void addItemToInventory(Item item){
        inventory.add(item);
    }

    public void removeItemFromInventoryByIndex(int index){
        inventory.remove(index);
    }

    public void updateItemInInventoryByIndex(int index,Item item){
        inventory.set(index,item);
    }


}
