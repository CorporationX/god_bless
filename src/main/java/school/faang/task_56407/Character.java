package school.faang.task_56407;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int intelligence, int agility, int strength) {
        this.name = name;
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
    }

    public abstract void attack(Character opponent);


    public boolean healthCheck() {
        if (this.health <= 0) {
            System.out.println("You don't have enough health!");
            return true;
        }
        return false;
    }
}
