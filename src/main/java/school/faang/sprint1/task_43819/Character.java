package school.faang.sprint1.task_43819;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    @Setter
    @Getter
    private int health = 100;
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intellect;

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    public void attack(Character character) {
    }

}
