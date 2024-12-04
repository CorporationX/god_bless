package school.faang.task_43812;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private static final int MAX_HEALTH = 100;

    private String name;
    private int health;
    private int power;
    private int skill;
    private int intellect;

    public Character(String name) {
        this.name = name;
        this.health = MAX_HEALTH;
    }

    public Character(String name, int power, int skill, int intellect) {
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.intellect = intellect;
        this.health = MAX_HEALTH;
    }

    abstract void attack(Character character);
}
