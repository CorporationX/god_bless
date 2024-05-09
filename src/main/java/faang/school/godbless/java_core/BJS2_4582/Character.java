package faang.school.godbless.java_core.BJS2_4582;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int force;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int agility, int intelligence) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
