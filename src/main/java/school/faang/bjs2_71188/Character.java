package school.faang.bjs2_71188;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }
}
