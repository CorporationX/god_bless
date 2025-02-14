package school.faang.sprint2.task_57368;

import lombok.Getter;

@Getter
public class Item {
    private final String name;
    private final int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
