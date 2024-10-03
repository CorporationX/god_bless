package bjs2_31292;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private Integer power;
    private Integer agility;
    private Integer intelligence;
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer agility, Integer intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
