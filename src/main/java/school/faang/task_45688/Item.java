package school.faang.task_45688;

import lombok.Data;

@Data
public class Item {
    private String name;

    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
