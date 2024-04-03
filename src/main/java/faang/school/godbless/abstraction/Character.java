package faang.school.godbless.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int health = 100;
    private int strength;
    private int dexterity;
    private int intelligence;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);
}
