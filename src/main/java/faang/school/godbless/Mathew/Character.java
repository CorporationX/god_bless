package faang.school.godbless.Mathew;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int inteligence;
    private int health;


    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int inteligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.inteligence = inteligence;
        this.health = 100;
    }
    public abstract void attack(Character character);



}
