package faang.school.godbless.abstractTask;

import lombok.Data;

@Data
abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(int strength, int agility, int intelligence, String name) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.name = name;
    }

    public Character(String name) {
        this.name = name;
    }


    public abstract void attack(Character character);

}
