package school.faang.task_50881;

import lombok.Data;

@Data
public class Item {
    private String name;
    private int power;

    public Item(String name, int power) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        this.power = power;
    }
}
