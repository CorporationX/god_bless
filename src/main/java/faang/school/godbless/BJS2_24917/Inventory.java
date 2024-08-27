package faang.school.godbless.BJS2_24917;

import java.util.List;

public record Inventory(List<Item> items) {

    public void addItem(Item item){
        items.add(item);
    }

}
