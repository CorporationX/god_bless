package school.faang;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    abstract void attack(Character character);

}
