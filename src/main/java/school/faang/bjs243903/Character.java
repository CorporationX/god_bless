package school.faang.bjs243903;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@NoArgsConstructor
public abstract class Character {
    @Getter
    private String name;
    @Getter
    private int power;
    @Getter
    private int agility;
    @Getter
    private int intellect;
    @Getter @Setter
    private int health = Constants.MAX_HEALTH;
    private double characterLuck;

    public Character(String name, int power, int agility, int intellect) {


        Random random = new Random();
        this.characterLuck = Constants.MIN_LUCK + random.nextDouble();

        this.name = name;
        this.power = (int) (power * characterLuck);
        this.agility = (int) (agility * characterLuck);
        this.intellect = (int) (intellect * characterLuck);

    }

    public abstract void attack(Character character);
}
