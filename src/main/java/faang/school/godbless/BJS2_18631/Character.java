package faang.school.godbless.BJS2_18631;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    @Getter @Setter
    private int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

}
