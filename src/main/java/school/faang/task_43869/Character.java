package school.faang.task_43869;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
