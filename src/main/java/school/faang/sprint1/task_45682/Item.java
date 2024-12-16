package school.faang.sprint1.task_45682;

import lombok.Getter;

@Getter
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
