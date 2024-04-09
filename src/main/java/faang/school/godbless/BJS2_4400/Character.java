package faang.school.godbless.BJS2_4400;

import lombok.Data;

@Data
abstract public class Character {
    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);
}
