package school.faang.task_43853;

import lombok.Getter;
import lombok.Setter;

import static school.faang.task_43853.CharacterProperties.CHARACTER_HEALTH;

@Getter
@Setter
public abstract class Character {
    private final String name;
    private final int power;
    private final int agility;
    private final int intellect;
    protected double health = CHARACTER_HEALTH;

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

    public boolean isAlive() {
        return health > 0;
    }
}
