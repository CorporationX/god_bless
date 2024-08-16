package Abstraction;


import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    @Getter
    @Setter
    protected String name;
    protected int strength; // сила
    protected int dexterity; // ловкость
    protected int intelligence; // интелект
    protected static int health = 100; // здоровье

    public Character(String name) {
        this.name = name;
    }

    public Character(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
