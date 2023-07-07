package Sprint_4_1_Task14;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Inventory {
    List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public Item combineItems(Item itemOne, Item itemTwo){
        String name = itemOne.getName() + " & " + itemTwo.getName();
        int power = itemOne.getPower() + itemTwo.getPower();
        return new Item(name, power);
    }
    public void assignPower(Item item, Item itemTwo){

    }
}
