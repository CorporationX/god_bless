package dota;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
    private List<Item> items = new ArrayList<>();

    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }

    public List<Item> getItems() {
        return items;
    }
}
