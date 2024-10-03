package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int hp;

    public Character(String name) {
        this.name = name;
        this.hp = 100;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.hp = 100;
    }

    protected abstract void attack(Character character);
}
