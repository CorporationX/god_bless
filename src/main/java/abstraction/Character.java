package abstraction;

import lombok.Getter;

@Getter
public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    public Character(String name) {
       expEmptyName(name);

        this.name = name;
        health = 100;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        expEmptyName(name);

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        health = 100;
    }

    public abstract void attack(Character character);

    public void expEmptyName(String name){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Пустое имя");
        }
    }
}
