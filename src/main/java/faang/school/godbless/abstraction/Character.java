package faang.school.godbless.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(int power, int agility, int intellect) {
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    protected abstract void attack(Character character);
}
