package faang.school.godbless.bjs2_7777;

import faang.school.godbless.bjs2_7777.default_values.CharacterDefaultValues;
import lombok.ToString;

@ToString
public abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this.name = name;
        this.health = CharacterDefaultValues.health;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = CharacterDefaultValues.health;
    }

    abstract void attack(Character attacked);
}
