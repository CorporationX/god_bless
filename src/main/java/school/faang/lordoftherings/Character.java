package school.faang.lordoftherings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public void updateItem(Item item, Item updatedItem) {
        int indexOf = inventory.indexOf(item);
        if (indexOf > 0) {
            inventory.set(indexOf, updatedItem);
        }
    }

    public void displayInventory() {
        inventory.forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
