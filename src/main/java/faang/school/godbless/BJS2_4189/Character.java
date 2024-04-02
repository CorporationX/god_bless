package faang.school.godbless.BJS2_4189;

import lombok.Data;

@Data
public abstract class Character {

    private String name;
    private int power;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

}
