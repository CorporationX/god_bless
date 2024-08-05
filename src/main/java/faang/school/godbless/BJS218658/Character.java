package faang.school.godbless.BJS218658;

import lombok.ToString;

@ToString
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int hp;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hp = 100;
    }

    public abstract void attack(Character enemy);
}
