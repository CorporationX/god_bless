package faang.school.godbless;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int Intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int dexterity, int intelligence) {
        this.power = power;
        this.dexterity = dexterity;
        Intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
