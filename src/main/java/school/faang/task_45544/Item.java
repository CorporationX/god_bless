package school.faang.task_45544;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import school.faang.task_45544.exception.CheckException;

@Getter
@Setter
@EqualsAndHashCode
public class Item {
    private String name;
    private Long value;

    public Item(String name, Long value) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("name of item");
        }
        if (value == null) {
            throw new CheckException("value of item");
        }

        this.name = name;
        this.value = value;
    }
}
