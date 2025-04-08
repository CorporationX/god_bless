package school.faang.bjs2_68140;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    protected String name;
    protected double strength;
    protected double agility;
    protected double intelligence;
    protected double health;

    public Character() {
        this.health = 100;
    }

    public abstract void attack(Character opponent);

    protected double calculateMaxDamage(Character opponent, double attackDamage) {
        return Math.min(opponent.getHealth(), attackDamage);
    }
}
