package school.faang.abstraction_abstraction.BJS2_56401;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Character {

    private static final int BASE_VALUE_OF_CHARACTERISTIC = 5;

    protected int strength;
    protected int dexterity;
    protected int intelligence;
    private final String name;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = BASE_VALUE_OF_CHARACTERISTIC;
        this.dexterity = BASE_VALUE_OF_CHARACTERISTIC;
        this.intelligence = BASE_VALUE_OF_CHARACTERISTIC;
    }

    public abstract void attack(Character opponent);

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }
}
