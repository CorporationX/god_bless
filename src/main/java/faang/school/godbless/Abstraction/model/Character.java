package faang.school.godbless.Abstraction.model;

import java.sql.SQLOutput;

public abstract class Character {
    protected String name;
    protected int force;
    protected int dexterity;
    protected int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int dexterity, int intelligence) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException("the enemy is dead");
        }
        this.health = health;
    }
}
