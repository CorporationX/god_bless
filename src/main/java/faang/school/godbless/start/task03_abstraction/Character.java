package faang.school.godbless.start.task03_abstraction;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }
    protected abstract void attack(Character character);


}
