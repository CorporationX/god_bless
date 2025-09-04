package school.faang.javacore.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {

    private final String name;
    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private int health = HeroesCharacteristics.CHARACTER_DEFAULT_HEALTH;

    protected Character(String name) {
        this.name = name;
        this.strength = HeroesCharacteristics.CHARACTER_DEFAULT_STRENGTH;
        this.dexterity = HeroesCharacteristics.CHARACTER_DEFAULT_DEXTERITY;
        this.intelligence = HeroesCharacteristics.CHARACTER_DEFAULT_INTELLIGENCE;
    }

    protected Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character opponent);

    protected void reduceHealth(Character opponent, int damage) {
        int resultHealth = opponent.getHealth() - damage;
        opponent.setHealth(Math.max(resultHealth, 0));
    }
}
