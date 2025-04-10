package BJS2_68191;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int AVERAGE_PROPERTIES_VALUE = 5;

    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name) {
        this.name = name;
        this.power = AVERAGE_PROPERTIES_VALUE;
        this.agility = AVERAGE_PROPERTIES_VALUE;
        this.intelligence = AVERAGE_PROPERTIES_VALUE;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attak(Character opponent);

    public void takeDamage(int damage) {
        if (this.health <= 0) {
            death();
            return;
        }

        this.health -= damage;
    }

    private void death() {
        System.out.println("The end");
    }
}



