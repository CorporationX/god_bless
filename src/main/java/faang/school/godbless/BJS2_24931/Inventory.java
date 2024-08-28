package faang.school.godbless.BJS2_24931;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inventory {
    @Getter
    private final List<Item> items = new ArrayList<>();
    private final Random random = new Random();

    public void addItem(Item item) {
        try {
            Thread.sleep(1000L * (1 + random.nextInt(5)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        items.add(item);
    }

    public Item combineItem(Item itemOne, Item itemTwo) {
        String combineName = itemOne.getName() + "_" + itemTwo.getName();
        int combinePower = itemOne.getPower() + itemTwo.getPower();
        return new Item(combineName, combinePower);
    }
}
