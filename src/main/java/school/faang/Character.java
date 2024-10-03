package school.faang;

import lombok.Data;

@Data
public abstract class Character {
    private int health = 100;
    private String name;
    private int power;
    private int dexterity;
    private int intellect;

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    abstract void attack(Character character);
}
