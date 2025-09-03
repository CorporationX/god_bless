package school.faang.javacore.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {

    private final String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = HeroesCharacteristics.CHARACTER_DEFAULT_HEALTH.getValue();

    protected Character(String name) {
        this.name = name;
        this.strength = HeroesCharacteristics.CHARACTER_DEFAULT_STRENGTH.getValue();
        this.dexterity = HeroesCharacteristics.CHARACTER_DEFAULT_DEXTERITY.getValue();
        this.intelligence = HeroesCharacteristics.CHARACTER_DEFAULT_INTELLIGENCE.getValue();
    }

    protected Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    abstract void attack(Character opponent);

    protected void reduceHealth(Character opponent, int damage) {
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
