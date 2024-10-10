package group.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Character {
    private int health = 100;
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character character);
}
