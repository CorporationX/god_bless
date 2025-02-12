package school.faang;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Character {

    private int health = 100;
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public abstract void attack(Character opponent);
}
