package faang.school.godbless.BJS2_18824;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {

    protected String name;
    protected int power;
    protected int dexterity;
    protected int brain;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int brain) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.brain = brain;
    }

    public abstract void attack(Character character);


}
