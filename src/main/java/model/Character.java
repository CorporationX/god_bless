package model;

import lombok.Data;

@Data
public abstract class Character  implements Attackable{
    protected String name;
    public int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name, int power, int dexterity, int intelligence) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    Character(String name) {
        this(name, 0, 0, 0);
    }
}
