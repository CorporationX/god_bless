package faang.school.godbless.javaCore.abstractAbstract;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health;

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.health = 100;
    }

    public abstract void attack(Character character);
}
