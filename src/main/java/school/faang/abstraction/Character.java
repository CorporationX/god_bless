package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected final String name;
    protected final int strength;
    protected final int dexterity;
    protected final int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = GameProperties.CHARACTER_DEFAULT_STRENGTH;
        this.dexterity = GameProperties.CHARACTER_DEFAULT_DEXTERITY;
        this.intellect = GameProperties.CHARACTER_DEFAULT_INTELLECT;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void setHealthPositive(Character opponent) {
        opponent.setHealth(Math.max(opponent.getHealth(), 0));
    }
}

