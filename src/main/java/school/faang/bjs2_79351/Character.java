package school.faang.bjs2_79351;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {
    private static final int MIDDLE_ATTRIBUTE = 5;

    private int health = 100;
    private String name;
    @Setter
    protected int strength;
    @Setter
    protected int agility;
    @Setter
    protected int intellect;

    public Character(String name) {
        this.name = name;
        this.strength = MIDDLE_ATTRIBUTE;
        this.agility = MIDDLE_ATTRIBUTE;
        this.intellect = MIDDLE_ATTRIBUTE;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

    public void setHealth(int health) {
        if (this.health - health >= 0) {
            this.health = health;
        } else {
            this.health = 0;
            System.out.println("Противник убит");
        }
    }
}
