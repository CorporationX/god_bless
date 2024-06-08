package faang.school.godbless.javaCore.abstraction;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    abstract Character attack(Character character);
}