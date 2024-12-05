package school.faang.task_43846;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100;
    }

    @Override
    public String toString() {
        return "\nName: " + name + ", Health: " + health;
    }

    public abstract void attack(Character character);
}

