package school.faang.task_48209;

import lombok.Data;

@Data
public class Unit {
    private final int power;

    public Unit(int power) {
        this.power = power;
    }
}
