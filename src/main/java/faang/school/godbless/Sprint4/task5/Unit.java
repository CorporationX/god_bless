package faang.school.godbless.Sprint4.task5;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Unit {
    String name;
    private int power;
    private int quantity;

    public String getName() {
        return name;
    }

    public int getPower() {
        return power * quantity;
    }
}
