package school.faang.sprint_2.task_45665;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Item {
    private final String name;

    @Setter
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

}
