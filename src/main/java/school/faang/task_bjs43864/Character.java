package school.faang.task_bjs43864;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public abstract class Character {
    private String name;
    private final int power;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);
}
