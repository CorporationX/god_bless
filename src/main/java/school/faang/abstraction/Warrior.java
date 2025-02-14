package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {
    private static int WARRIOR_STRENGTH_VALUE = 10;
    private static int WARRIOR_AGILITY_VALUE = 5;
    private static int WARRIOR_INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH_VALUE, WARRIOR_AGILITY_VALUE, WARRIOR_INTELLIGENCE_VALUE);
    }

    @Override
    void attack(Character opponent) {
        if (opponent.getHp() > 0) {
            int newHp = Math.max(0, opponent.getHp() - getStrength());
            opponent.setHp(newHp);
            System.out.println("Opponent was damaged by " + getStrength());
        }
        if (opponent.getHp() == 0) {
            System.out.println("Opponent is dead");
        }
    }
}
