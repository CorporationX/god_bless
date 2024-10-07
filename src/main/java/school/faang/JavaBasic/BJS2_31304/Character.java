package school.faang.JavaBasic.BJS2_31304;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    abstract void attack(Character character);

    protected void reduceHealth(int amount) {
        this.health -= amount;
    }
}
