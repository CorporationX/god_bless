package school.faang.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    void addItem(Item item) {
        inventory.add(item);
    }

    void removeItem(Item item) {
        inventory.remove(item);
    }

    void updateItem(Item oldItem, Item newItem) {
        int index = inventory.indexOf(oldItem);
        if (index != -1) {
            inventory.set(index, newItem);
        }
    }
}
