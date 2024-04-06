package faang.school.godbless.characters;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {
    private final String name;
    private int power;
    private int agility;
    private int intelligence;
    @Setter
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character ch);
}
