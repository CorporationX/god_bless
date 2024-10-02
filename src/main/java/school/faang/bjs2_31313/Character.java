package school.faang.bjs2_31313;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;
    protected int hp = 100;


    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
