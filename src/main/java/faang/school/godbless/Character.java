package faang.school.godbless;

import lombok.Data;

@Data
public abstract class Character {

    protected String name;
    protected Integer force;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

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
