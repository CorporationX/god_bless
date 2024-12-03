package school.faang.task_43825;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Character {
    @Setter
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    @Getter
    @Setter
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character target);

}
