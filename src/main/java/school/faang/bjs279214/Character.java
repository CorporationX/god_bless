package school.faang.bjs279214;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intellect;
    protected int health = 100;

    public Character(String name, int strength, int dexterity, int intellect) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
        strength = 5;
        dexterity = 5;
        intellect = 5;
    }

    public abstract void attack(Character opponent);

}
