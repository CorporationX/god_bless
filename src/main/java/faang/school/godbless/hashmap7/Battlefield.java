package faang.school.godbless.hashmap7;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Battlefield {
    private final Hero attacker;
    private final Hero defender;

    public Hero battle() {
        if (getStrength(attacker.getArmy()) > getStrength(defender.getArmy())) {
            return attacker;
        } else {
            return defender;
        }
    }

    public int getStrength(List<Creature> army) {
        int strength = 0;
        for (Creature creature : army) {
            strength += creature.getQuantity();
        }
        return strength;
    }
}
