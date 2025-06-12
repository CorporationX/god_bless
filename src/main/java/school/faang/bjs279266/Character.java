package school.faang.bjs279266;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.dexterity = 5;
        this.intelligence = 5;
        this.health = 100;
    }
    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character opponent);
}
