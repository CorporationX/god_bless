package school.faang.task_45555.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {
    private final String name;
    private final int value;

    public Item(String name, int value) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is null or empty");
        }
        this.name = name;
        this.value = value;
    }
}
