package school.faang.task_43830;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health;
    private static final int HEALTH = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = HEALTH;
    }

    public abstract void attack(Character player);
}
