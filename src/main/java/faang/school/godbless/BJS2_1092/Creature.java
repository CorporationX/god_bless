package faang.school.godbless.BJS2_1092;

import lombok.Data;

@Data
public abstract class Creature {
    private String name;
    private int power;
    private int quantity;

    public Creature(String name, int power, int quantity) {
        this.name = name;
        this.power = power;
        this.quantity = quantity;
    }

    public int getPower() {
        return this.power * quantity;
    }
}