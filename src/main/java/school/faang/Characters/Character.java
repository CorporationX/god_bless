package school.faang.Characters;

import lombok.Data;

@Data
abstract public class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    abstract public void attack(Character defender);

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }
}
