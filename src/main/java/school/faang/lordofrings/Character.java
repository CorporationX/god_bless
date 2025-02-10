package school.faang.lordofrings;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {

    @NonNull
    private final String name;
    @Setter
    private List<Item> inventory = new ArrayList<>();

    public Character(@NonNull String name) {
        this.name = name;
    }

    public void addItem(@NonNull Item item) {
        if (!inventory.contains(item)) {
            inventory.add(item);
        }
    }
}
