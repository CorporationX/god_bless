package faang.school.godbless.abstraction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected Integer force;
    protected Integer dexterity;
    protected Integer iq;
    protected Integer healthPoint = 100;


    public Character(String name, Integer force, Integer dexterity, Integer iq) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.iq = iq;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);
}
