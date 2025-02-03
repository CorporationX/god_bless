package school.faang.task_56329;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        agility = 5;
        intelligence = 5;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.strength = power;
        this.agility = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack (Character opponent);
}
