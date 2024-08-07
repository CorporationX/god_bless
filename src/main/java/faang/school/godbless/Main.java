package faang.school.godbless;
import lombok.Setter;

abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    @Setter
    private int health;

    public Character(String name) {
        this(name, 0, 0, 0); // Call the other constructor with default values for strength, agility, and intelligence
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100; // default health value
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public abstract void attack(Character opponent);

    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}

class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        opponent.receiveDamage(damage);
    }
}

// Archer class
class Archer extends Character {

    // Constructor
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    // Override attack method
    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        opponent.receiveDamage(damage);
    }
}

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thor");
        Archer archer = new Archer("Legolas");

        System.out.println("Warrior health: " + warrior.getHealth());
        System.out.println("Archer health: " + archer.getHealth());

        // Warrior attacks Archer
        warrior.attack(archer);
        System.out.println("Archer health after attack: " + archer.getHealth());

        // Archer attacks Warrior
        archer.attack(warrior);
        System.out.println("Warrior health after attack: " + warrior.getHealth());
    }
}