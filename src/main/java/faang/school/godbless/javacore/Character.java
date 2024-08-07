package faang.school.godbless.javacore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    protected Integer power;
    protected Integer agility;
    protected Integer intelligence;
    private Integer Health = 100;

    public Character(String name, Integer power, Integer agility, Integer intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + getName() + " | health-" + getHealth();
    }
}
