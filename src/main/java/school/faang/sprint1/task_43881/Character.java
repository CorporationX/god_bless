package school.faang.sprint1.task_43881;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class Character {

    private static final int DEFAULT_HEALTH = 100;

    protected String name;
    protected int power;
    protected int dexterity;
    protected int intellect;
    protected int health = DEFAULT_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int dexterity, int intellect, int health) {
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health = health;
    }

    public abstract void attac(Character character);
}
