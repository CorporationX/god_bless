package school.faang.abstraction_abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String name;
    private Integer strength;
    private Integer agility;
    private Integer intellect;
    private Integer health = 100;

    private static final int STRENGTH_VALUE = 5;
    private static final int AGILITY_VALUE = 5;
    private static final int INTELLIGENCE_VALUE = 5;

    public Character(String name) {
        this.name = name;
        this.strength = STRENGTH_VALUE;
        this.agility = AGILITY_VALUE;
        this.intellect = INTELLIGENCE_VALUE;
    }

    public Character(String name, Integer strength, Integer agility, Integer intellect) {
        if (strength < 0 || agility < 0 || intellect < 0) {
            throw new IllegalArgumentException("Характеристики не могут быть отрицательными");
        }

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public abstract void attack(Character opponent);

}
