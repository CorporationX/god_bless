package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;

@Getter
public abstract class Creature {
    protected int power;
    protected int quantity;
    protected String name;

    public Creature(int quantity) {
        this.quantity = quantity;
    }
}
