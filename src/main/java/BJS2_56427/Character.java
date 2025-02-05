package BJS2_56427;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intel;
    public int health;

    public Character(String name, int strength, int agility, int intel) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intel = intel;
        this.health = 100;
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intel = 5;
        this.health = 100;
    }

    public abstract void attack(Character opponent);

    public void checkHealth() {
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
