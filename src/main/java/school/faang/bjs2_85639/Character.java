package school.faang.bjs2_85639;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    private byte health = 100;

    Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    void attack(Character opponent) {}

    void recieveDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }

    byte getHealth() {
        return health;
    }
}
