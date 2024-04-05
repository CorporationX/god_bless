package faang.school.godbless.bjs2_4226;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    protected String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
