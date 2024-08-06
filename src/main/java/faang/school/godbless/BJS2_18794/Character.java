package faang.school.godbless.BJS2_18794;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);


}
