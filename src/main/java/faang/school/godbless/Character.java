package faang.school.godbless;

import lombok.Data;

@Data
abstract class Character {
    private final String name;
    protected int power;
    protected int agility;
    protected int smart;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int smart) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.smart = smart;
    }

    abstract void attack(Character character);
}
