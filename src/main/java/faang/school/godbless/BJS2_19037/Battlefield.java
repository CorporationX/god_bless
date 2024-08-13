package faang.school.godbless.BJS2_19037;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public Hero battle() {
        int moves = 0;
        while (!attacker.isDefeated() && !defender.isDefeated()) {
            if (moves % 2 == 0) {
                attack(attacker, defender);
            } else {
                attack(defender, attacker);
            }
            moves++;
        }
        return attacker.isDefeated() ? defender : attacker;
    }

    private void attack(Hero attacker, Hero defender) {
        List<Creature> attackerArmy = attacker.getArmy();
        List<Creature> defenderArmy = defender.getArmy();
        Creature attackerCreature = attackerArmy.get(new Random().nextInt(attackerArmy.size()));
        Creature defenderCreature = defenderArmy.get(new Random().nextInt(defenderArmy.size()));
        int damage = attackerCreature.getDamage() - defenderCreature.getDefense();
        if (damage > 0) {
            boolean isAlive = defenderCreature.getHealth() > damage;
            if (!isAlive) {
                defenderCreature.decreaseQuantity();
                if (defenderCreature.getQuantity() <= 0) {
                    defender.removeCreature(defenderCreature);
                }
            }
        }
    }
}
