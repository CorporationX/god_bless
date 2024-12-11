package school.faang.task_45544;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Item {
    private String name;
    private Long value;

    public Item(String name, Long value) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name of item не может быть пустым");
        }
        if (value == null) {
            throw new IllegalArgumentException("value of item не может быть пустым");
        }

        this.name = name;
        this.value = value;
    }
}
