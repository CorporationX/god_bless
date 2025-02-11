package school.faang.sprint.second.rpg;

import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
    @NonNull
    private String name;
    private int value;

    public Item(@NonNull String name, int value) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.value = value;
    }
}
