package school.faang.carry.storages;

import lombok.NoArgsConstructor;
import school.faang.carry.Item;

@NoArgsConstructor
public class Inventory extends ItemStorage {
    private static final int MAX_NUM_OF_ITEMS = 6;

    @Override
    public synchronized void addItem(Item item) {
        if (isFull()) {
            throw new IllegalStateException("в инвентаре нет места");
        }
        super.addItem(item);
    }

    public static Item combineItems(Item item1, Item item2) {
        System.out.println("комбинируем: " + item1 + " + " + item2);
        return item1.combineWith(item2);
    }

    private boolean isFull() {
        return super.getSize() == MAX_NUM_OF_ITEMS;
    }
}
