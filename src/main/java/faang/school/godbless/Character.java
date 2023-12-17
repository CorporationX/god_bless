package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected long force;
    protected long dexterity;
    protected long intelligence;
    protected byte health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, long force, long dexterity, long intelligence) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character character);

}
