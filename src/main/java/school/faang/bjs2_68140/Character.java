package school.faang.bjs2_68140;

import lombok.Getter;
import lombok.ToString;

import static school.faang.bjs2_68140.GameProperties.DEFAULT_AGILITY;
import static school.faang.bjs2_68140.GameProperties.DEFAULT_HEALTH;
import static school.faang.bjs2_68140.GameProperties.DEFAULT_INTELLIGENCE;
import static school.faang.bjs2_68140.GameProperties.DEFAULT_STRENGTH;

@ToString
@Getter
public abstract class Character {
    private final String name;
    private final double strength;
    private final double agility;
    private final double intelligence;
    private double health;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name, double strength, double agility, double intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character opponent);

    protected double calculateMaxDamage(Character opponent, double attackDamage) {
        return Math.min(opponent.getHealth(), attackDamage);
    }

    protected void setHealth(double health) {
        this.health = health;
    }
}
