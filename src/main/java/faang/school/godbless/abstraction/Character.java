package faang.school.godbless.abstraction;

import lombok.ToString;

@ToString
public abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer dexterity;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer dexterity, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character attackedChar);
}
