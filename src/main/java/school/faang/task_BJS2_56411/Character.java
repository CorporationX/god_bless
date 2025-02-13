package school.faang.task_BJS2_56411;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void getDamage(Character character);

    public boolean isHealthyLessZero(int initialHealth, int adjustedValue) {
        return Math.max(initialHealth - adjustedValue, 0) == 0;
    }

    @Override
    public String toString() {
        return ("name: "        + this.getName() +
                "; strength: "  + this.getStrength() +
                "; agility: "   + this.getAgility() +
                "; intellect: " + this.getIntellect() +
                "; health: "    + this.health
                );
    }
}
