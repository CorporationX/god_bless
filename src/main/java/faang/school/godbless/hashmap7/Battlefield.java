package faang.school.godbless.hashmap7;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Battlefield {
    private final Hero ATTACKER;
    private final Hero DEFENDER;

    public Hero battle() {
        if (getStrength(ATTACKER.getArmy()) > getStrength(DEFENDER.getArmy())) {
            return ATTACKER;
        } else {
            return DEFENDER;
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
