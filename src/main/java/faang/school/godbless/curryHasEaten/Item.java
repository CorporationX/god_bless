package faang.school.godbless.curryHasEaten;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String name;
    private Integer power;

    public Item(String name, Integer power) {
        this.name = name;
        this.power = power;
    }
}