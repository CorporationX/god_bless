package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String Name;
    protected Long Force;
    protected Long Dexterity;
    protected Long Intelligence;
    protected Long Health = 100l;

    public Character(String name) {
        Name = name;
    }

    public Character(Long force, Long dexterity, Long intelligence) {
        Force = force;
        Dexterity = dexterity;
        Intelligence = intelligence;
    }

    protected abstract void attack(Character character);

}
