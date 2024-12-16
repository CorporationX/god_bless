package school.faang.task_47681;

import lombok.Getter;

@Getter
public class Unit {
    private final int power;
    private final String type;

    public Unit(int power, String type) {
        this.power = power;
        this.type = type;
    }

}