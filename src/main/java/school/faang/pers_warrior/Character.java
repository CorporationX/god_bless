package school.faang.pers_warrior;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intellect;
    private Integer hitPoints = 100;

    public Character(String name, Integer strength, Integer agility, Integer intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);
}
