package faang.school.godbless.BJS27788;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    @Setter
    @Getter
    protected int health = 100;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    protected abstract void attack(Character character);

}
