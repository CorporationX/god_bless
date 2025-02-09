package school.faang.BJS2_56484;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        power = 5;
        agility = 5;
        intelligence = 5;
        health = 100;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        health = 100;
    }

    public abstract void attack(Character opponent);

    public boolean hasHealth() {
        return this.health > 0;
    }

}
