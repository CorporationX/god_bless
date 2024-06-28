package faang.school.godbless.curryHasEaten;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Item {
    private String name;
    private Integer power;

    public Item() {
        this.name = name;
        this.power = power;
    }
}