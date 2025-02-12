package school.faang.task57454.service;

import java.util.function.Consumer;

public class InventoryManager {
    public void addItem(Character pers, Item item, Consumer<Item> consumer) {
        pers.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem() {

    }

    public void updateItem() {

    }
}
