package faang.school.godbless.abstraction_abstraction;

import lombok.ToString;

@ToString
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be null or empty");
        }
        this.name = name;
    }
    //No null checks for stats because its a task about inheritance womp womp :(
    public Character(String name, int strength, int agility, int intelligence) {
        this(name);
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
