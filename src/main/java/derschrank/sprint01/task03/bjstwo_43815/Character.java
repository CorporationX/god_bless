package derschrank.sprint01.task03.bjstwo_43815;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;

    private final String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health;
    protected String type;

    public Character(String name) {
        this("Ghost", name, 0, 0, 0);
    }

    public Character(String type, String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.type = type;
        health = DEFAULT_HEALTH;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    protected void receiveDamage(int damage) {
        if (damage < 0) {
            return;
        }
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (strength: %d, dexterity: %d, intelligence: %d), has health: %d",
                type, name, strength, dexterity, intelligence, health);
    }
}
