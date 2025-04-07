package school.faang.abstraction.entitiy;

import lombok.Getter;

@Getter
public abstract class Creature {
    private static final int DEFAULT_HEALTH = 100;
    private static final int AVERAGE_PROPERTIES_VALUE = 5;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;

    private int health;

    public Creature(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public Creature(String name) {
        this.name = name;
        this.strength = AVERAGE_PROPERTIES_VALUE;
        this.agility = AVERAGE_PROPERTIES_VALUE;
        this.intelligence = AVERAGE_PROPERTIES_VALUE;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Creature target);

    public void takeDamage(int damage) {
        if (this.health <= 0) {
            die();
            return;
        }

        this.health -= damage;
    }

    private void die() {
        System.out.println("Creature died");
    }
}
