package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int force;
    protected int agility;
    protected int intellect;
    protected int hp = 100;

    public Character(String name){
        this.name = name;
    }

    public Character(String name, int force, int agility, int intellect) {
        this(name);
        this.force = force;
        this.agility = agility;
        this.intellect = intellect;
    }

    abstract void attack(Character character);

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", force=" + force +
                ", agility=" + agility +
                ", intellect=" + intellect +
                ", hp=" + hp +
                '}';
    }
}
