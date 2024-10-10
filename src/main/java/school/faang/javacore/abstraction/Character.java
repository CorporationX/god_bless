package school.faang.javacore.abstraction;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class  Character {
    private String name;
    private int power;
    private int agility;    // Ловкость
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}