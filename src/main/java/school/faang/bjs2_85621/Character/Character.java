package school.faang.bjs2_85621.Character;

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

    public void checkPutHealth(int healthOpponent) {
        if (healthOpponent <= 0) {
            health = 0;
            System.out.print(name + " погиб. ");
        }
    }

    public void receiveDamage(int damage) {
        if (damage >= 0 && health > 0) {
            health -= damage;
        }
        checkPutHealth(health);
        System.out.println("Heals: " + health);
    }

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);
}
