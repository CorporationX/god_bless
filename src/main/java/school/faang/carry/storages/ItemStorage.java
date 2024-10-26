package school.faang.carry.storages;

import lombok.NoArgsConstructor;
import school.faang.carry.Item;
import school.faang.carry.Player;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public abstract class ItemStorage {
    private final List<Item> items = new ArrayList<>();

    public ItemStorage(List<Item> items) {
        this.items.addAll(items);
    }

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public synchronized Item getItem(Item item, Player player) {
        validate(item, player);
        return items.remove(items.indexOf(item));
    }

    public synchronized int getSize() {
        return items.size();
    }

    protected void validate(Item item, Player player) {
        if (item == null) {
            throw new IllegalArgumentException("item не может быть null");
        }
        if (!items.contains(item)) {
            throw new IllegalArgumentException("предмет " + item + " не был найден");
        }
        if (player == null) {
            throw new IllegalArgumentException("player не может быть null");
        }
    }
}
