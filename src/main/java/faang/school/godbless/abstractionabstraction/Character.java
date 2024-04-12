package faang.school.godbless.abstractionabstraction;

import lombok.Data;

@Data
public abstract class Character {
    private final static int DEFAULT_HEALTH_POINTS = 100;
    private final String name;
    private int power;
    private int dexterity;
    private int intelligence;
    private int health;

    protected Character(final String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH_POINTS;
    }

    protected Character(final String name, final int power, final int dexterity, final int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH_POINTS;
    }

    public abstract void attack(Character character);
}
