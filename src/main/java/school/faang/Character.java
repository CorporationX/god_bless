package school.faang;

import lombok.Getter;

public abstract class Character {
    private final int defaultHealth = 100;

    @Getter
    private final String name;
    @Getter
    private final int strength;
    @Getter
    private final int agility;
    @Getter
    private final int intelligence;
    @Getter
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = 10;
        this.agility = 10;
        this.intelligence = 10;
        this.health = defaultHealth;
    }

    protected Character(String name, int initialStrength, int initialAgility,int initialIntelligence) {
        this.name = name;
        this.strength = initialStrength;
        this.agility = initialAgility;
        this.intelligence = initialIntelligence;
        this.health = defaultHealth;
    }

    public abstract void attack(Character character);

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public boolean isDead() {
        return this.health == 0;
    }
}
