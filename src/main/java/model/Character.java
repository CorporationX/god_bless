package model;

import lombok.Data;

@Data
public abstract class Character  implements Attackable{
    protected String name;
    public int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    Character(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("Name is empty");
        } else {
            this.name = name;
        }
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
}
