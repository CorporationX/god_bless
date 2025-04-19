package school.faang.bjs2_71188;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }
}
