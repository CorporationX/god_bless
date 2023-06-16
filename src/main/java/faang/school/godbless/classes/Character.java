package faang.school.godbless.classes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int flexability;
    private int intelligence;
    private int health = 100;

    private Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int flexability, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.flexability = flexability;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
