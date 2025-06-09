package school.faang.BJS2_79250.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int DEFAULT_ATTRIBUTE_VALUE = 5;
    private static final int DEFAULT_HEALTH_VALUE = 100;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = DEFAULT_HEALTH_VALUE;

    protected Character(String name) {
        this.setName(name);
        this.setStrength(DEFAULT_ATTRIBUTE_VALUE);
        this.setAgility(DEFAULT_ATTRIBUTE_VALUE);
        this.setIntelligence(DEFAULT_ATTRIBUTE_VALUE);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.setName(name);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setIntelligence(intelligence);
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
            return;
        }
        this.health = health;
    }

    public abstract void attack(Character character);
}
