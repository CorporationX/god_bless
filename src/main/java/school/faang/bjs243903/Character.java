package school.faang.bjs243903;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public abstract class Character {
    private final String name;
    private final int power;
    private final int agility;
    private final int intellect;
    private int health;

    public Character(String name, int power, int agility, int intellect) {

        Random random = new Random();
        double characterLuck = Constants.MIN_LUCK + random.nextDouble();

        this.name = name;
        this.power = (int) (power * characterLuck);
        this.agility = (int) (agility * characterLuck);
        this.intellect = (int) (intellect * characterLuck);
        this.health = Constants.MAX_HEALTH;

    }

    public abstract void attack(Character character);
}
