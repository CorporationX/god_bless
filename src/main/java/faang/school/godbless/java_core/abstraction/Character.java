package faang.school.godbless.java_core.abstraction;

import lombok.Getter;
import lombok.Setter;


public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    @Getter @Setter protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
