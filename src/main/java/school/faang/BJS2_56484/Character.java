package school.faang.BJS2_56484;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int power = 5;
    private int agility = 5;
    private int intelligence = 5;
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

    public abstract void attack(Character opponent);

    public boolean hasHealth() {
        return this.health > 0;
    }

}
