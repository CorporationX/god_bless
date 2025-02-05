package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public void checkOpponentHealth(Character opponent, int injury) {
        if (opponent.health - injury < 0) {
            throw new IllegalArgumentException("Health can't be less 0");
        }
    }

    public abstract void attack(Character opponent);

}


