package faang.school.godbless.lordOfRings;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public void addItemToInventory(Item item){
        inventory.add(item);
    }
}
