package faang.school.godbless.distributedArmy;

import lombok.Data;

@Data
public class Unit {
    private String name;
    private int power;

    public Unit(String name, int power) {
        this.name = name;
        this.power = power;
    }
}
