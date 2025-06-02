package school.faang.bjs2_79163;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        intelligence = 5;
        agility = 5;
    }

    public Character(String name, int strength, int agility) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
    }

    public void setHealth(int health) {
        if (this.health == 0) {
            System.out.println("Противник уже повержен");
            return;
        }
        if (health < 0) {
            health = 0;
            System.out.println("Противник повержен");
        }
        this.health = health;
    }

    public void printStats() {
        System.out.println("------------");
        System.out.println("name: " + name);
        System.out.println("strength: " + strength);
        System.out.println("agility: " + agility);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("health: " + health);
        System.out.println("------------");
    }

    public abstract void attack(Character defender);
}
