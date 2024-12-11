package school.faang.bjs_45575;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    @Getter
    private final String name;

    public List<Item> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    public void addItem(Item item) {
        if (item == null) {
            return;
        }

        inventory.add(item);
    }

    public void removeItem(Item item) {
        if (item == null) {
            return;
        }
        inventory.remove(item);
    }

    public void updateItem(Item updatedItem) {
        if (updatedItem == null || inventory.contains(updatedItem)) {
            return;
        }

        inventory.stream()
                .filter(item -> item.getName().equals(updatedItem.getName()))
                .forEach(item -> item.setValue(updatedItem.getValue()));
    }
}
