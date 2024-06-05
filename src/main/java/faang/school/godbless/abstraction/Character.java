package faang.school.godbless.abstraction;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NonNull
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this(name);
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
        this.health = 100;
    }

    public abstract void attac(Character character);
}
