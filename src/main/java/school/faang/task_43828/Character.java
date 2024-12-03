package school.faang.task_43828;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
