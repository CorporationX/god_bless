package faang.school.godbless.Sprint2.task3_Sprint2;

import lombok.Getter;
import lombok.Setter;

@Getter
abstract public class Character {
    protected String name;
    protected double force;
    protected double agility;
    protected double intelligence;
    @Setter
    protected double health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, double force, double agility, double intelligence) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character deffer);
}
