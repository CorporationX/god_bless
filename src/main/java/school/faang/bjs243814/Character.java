package school.faang.bjs243814;

import lombok.Getter;
import lombok.Setter;
import java.util.Random;

import static school.faang.bjs243814.Constants.ARCHER_POWER;
import static school.faang.bjs243814.Constants.ARCHER_AGILITY;
import static school.faang.bjs243814.Constants.ARCHER_INTELLECT;
import static school.faang.bjs243814.Constants.WARRIOR_POWER;
import static school.faang.bjs243814.Constants.WARRIOR_AGILITY;
import static school.faang.bjs243814.Constants.WARRIOR_INTELLECT;

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

    public Character(String name) {
        Random random = new Random();
        double characterLuck = Constants.MIN_LUCK + random.nextDouble();

        this.name = name;
        this.power = (int) (this instanceof Archer ? ARCHER_POWER : WARRIOR_POWER * characterLuck);
        this.agility = (int) (this instanceof Archer ? ARCHER_AGILITY : WARRIOR_AGILITY * characterLuck);
        this.intellect = (int) (this instanceof Archer ? ARCHER_INTELLECT : WARRIOR_INTELLECT * characterLuck);
        this.health = Constants.MAX_HEALTH;
    }

    public abstract void attack(Character character);
}
