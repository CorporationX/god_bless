package abstractionAbstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int intelligence, int dexterity, int strength, String name) {
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.strength = strength;
        this.name = name;
    }

    public abstract void attack(Character target);

}
