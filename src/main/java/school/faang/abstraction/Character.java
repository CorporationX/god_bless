package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int force;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int agility, int intellect) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
