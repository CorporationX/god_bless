package school.faang.abstraction;

import lombok.ToString;

@ToString
public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name, int strength, int agility, int intellect) {
        if (!(validData(name, strength, agility, intellect))) {
            this.name = name;
            this.strength = strength;
            this.agility = agility;
            this.intellect = intellect;
        }
    }

    private boolean validData(String name, int strength, int agility, int intellect) {
        return name == null
                || name.isBlank()
                || strength == 0
                || agility == 0
                || intellect == 0;
    }

    abstract void attack(Character character);
}