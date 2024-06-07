package faang.school.godbless.Abstract_abstract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Characters {
    protected String name;
    protected int force;
    protected int agility;
    protected int intellect;
    protected int hp = 100;

    public Characters(String name){
        this.name = name;
    }

    public Characters(String name, int force, int agility, int intellect) {
        this(name);
        this.force = force;
        this.agility = agility;
        this.intellect = intellect;
    }

    abstract void attack(Characters characters);

    @Override
    public String toString() {
        return "Characters{" +
                "name='" + name + '\'' +
                ", force=" + force +
                ", agility=" + agility +
                ", intellect=" + intellect +
                ", hp=" + hp +
                '}';
    }
}
