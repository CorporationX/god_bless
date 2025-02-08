package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Archer extends Character {
    private static int ARCHER_STRENGTH_VALUE = 3;
    private static int ARCHER_AGILITY_VALUE = 10;
    private static int ARCHER_INTELLIGENCE_VALUE = 5;

    public Archer(String name) {
        super(name);
        super.setAgility(ARCHER_AGILITY_VALUE);
        super.setIntelligence(ARCHER_INTELLIGENCE_VALUE);
        super.setStrength(ARCHER_STRENGTH_VALUE);
    }

    @Override
    void attack(Character opponent) {
        if (opponent.getHp() > 0) {
            opponent.setHp(opponent.getHp() - getAgility());
            System.out.println("Opponent was damaged by " + getAgility());
        }
        if (opponent.getHp() <= 0) {
            System.out.println("Opponent is dead");
        }
    }
}