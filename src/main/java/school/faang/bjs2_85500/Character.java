package school.faang.bjs2_85500;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {
    private static final int STRENGTH_VALUE = 5;
    private static final int AGILITY_VALUE = 5;
    private static final int INTELLIGENCE_VALUE = 5;
    private static final int HEALTH_VALUE = 100;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health =  HEALTH_VALUE;

    public Character(String name) {
        this.name = name;
        this.strength = STRENGTH_VALUE;
        this.agility = AGILITY_VALUE;
        this.intelligence = INTELLIGENCE_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    abstract void attack(Character opponent);
}
