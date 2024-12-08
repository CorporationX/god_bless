package school.faang.task45502;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Item {
    private final String name;
    @Setter
    private int value;

    public Item(String name, int value) {
        validate(name);

        this.name = name;
        this.value = value;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
