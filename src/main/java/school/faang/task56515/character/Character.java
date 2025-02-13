package school.faang.task56515.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int STRENGTH = 5;
    private static final int INTELLIGENCE = 5;
    private static final int DEXTERITY = 5;

    private String name;
    protected Integer strength;
    protected Integer dexterity;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = STRENGTH;
        this.dexterity = DEXTERITY;
        this.intelligence = INTELLIGENCE;
    }

    public Character(String name, Integer strength, Integer dexterity, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);
}
