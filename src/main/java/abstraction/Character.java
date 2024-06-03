package abstraction;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected Integer power;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer agility, Integer intelligence) {
        this(name);
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
