package school.module1.task43832;

import lombok.Getter;

@Getter
abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    protected int health = 100;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);

    public void setHealth(int health) {
        this.health = health;
    }
}
