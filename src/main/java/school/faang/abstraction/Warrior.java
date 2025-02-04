package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Warrior extends Character {
    private static final int DEFAULT_WARRIOR_STRENGTH = 10;
    private static final int DEFAULT_WARRIOR_AGILITY = 5;
    private static final int DEFAULT_WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        strength = DEFAULT_WARRIOR_STRENGTH;
        agility = DEFAULT_WARRIOR_AGILITY;
        intelligence = DEFAULT_WARRIOR_INTELLIGENCE;
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        if (canAttack(this.health)) {
            opponent.setHealth(opponent.getHealth() - this.strength);
            equateToZeroIfNegative(opponent);
        }
    }
}
