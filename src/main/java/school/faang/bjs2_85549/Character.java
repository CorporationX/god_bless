package school.faang.bjs2_85549;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private String name;
    private int strength = 5;
    private int agility = 5;
    private int intellect = 5;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character opponent);

    public boolean notDead() {
        return health > 0;
    }
}
