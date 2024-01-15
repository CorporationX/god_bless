package faang.school.godbless.multithreading_async.carry_had_a_blast;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
}
