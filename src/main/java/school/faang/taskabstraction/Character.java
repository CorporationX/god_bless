package school.faang.taskabstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int power;
    protected int health = 100;
    protected int agility;
    protected int intelligence;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int intelligence, int agility, int power) {
        this.intelligence = intelligence;
        this.agility = agility;
        this.power = power;
        this.name = name;
    }

    public abstract void attack(Character character);

    @Override
    public String toString() {
        return "Character{"
                + "name='" + name + '\''
                + ", power=" + power
                + ", health=" + health
                + ", agility=" + agility
                + ", intelligence=" + intelligence
                +
                '}';
    }
}

