package faang.school.godbless.characters;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    private int force;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int agility, int intelligence) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public void decreaseHealth(int value) {
        if (value <= 0) return;
        health = value < health ? health - value : 0;
    }

}
