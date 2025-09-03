package school.faang.bjs2_85543;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private int health = 100;
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

}
