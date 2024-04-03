package faang.school.godbless.BJS2_4124;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.initCharacter(name, 0, 0, 0);
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.initCharacter(name, power, agility, intelligence);
    }

    private void initCharacter(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character character);
}
