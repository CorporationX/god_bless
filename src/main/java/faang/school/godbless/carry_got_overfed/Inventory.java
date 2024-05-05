package faang.school.godbless.carry_got_overfed;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void combineItem(Item item1, Item item2){
        int combinePower = item1.getPower() + item2.getPower();
        String combineName = item1.getName() + "|" + item2.getName();
        items.add(new Item(combineName, combinePower));
    }
}
