package school.faang.task_43857;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import static school.faang.task_43857.Properties.AGILITY;
import static school.faang.task_43857.Properties.INTELLECT;
import static school.faang.task_43857.Properties.POWER;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public abstract class Character {
    private final String name;
    private final int power;
    private final int agility;
    private final int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.power = POWER;
        this.agility = AGILITY;
        this.intellect = INTELLECT;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    protected abstract void attack(Character character);
}