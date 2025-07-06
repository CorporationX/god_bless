package school.faang.bjs2_82718;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class Chest extends SpaceItem {
    private final String name;

    public Chest(String name, @NonNull List<Item> items) {
        super(items);
        this.name = name;
    }
}
