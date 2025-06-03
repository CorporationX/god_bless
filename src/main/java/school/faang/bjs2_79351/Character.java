package school.faang.bjs2_79351;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    @Getter
    private int health = 100;
    private String name;
    @Setter @Getter
    private int strength;
    @Setter @Getter
    private int agility;
    @Setter
    private int intellect;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

    public void setHealth(int health) {
        if (this.health - health >= 0) {
            this.health = health;
        } else {
            this.health = 0;
            System.out.println("Противник убит");
        }
    }
}
