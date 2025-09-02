package school.faang.BJS2_85489;

import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = true)
public abstract class Character {
    private final String name;
    @Getter
    private final double strength;
    @Getter
    private final double dexterity;
    private final double intelligence;
    private double health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        dexterity = 5;
        intelligence = 5;
    }

    public Character(String name, double strength, double dexterity, double intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public boolean isAlive() {
        return health > 0;
    }

    abstract void attack(Character opponent);

    void decrementHealth(double attackPoints) {
        health = Math.max(0, health - attackPoints);
    }
}
