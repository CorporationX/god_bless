package faang.school.godbless.BJS27979;

import faang.school.godbless.BJS27979.Creatures.Creature;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public void fightRound() {
        List<Creature> fightingCreatures = getTurnOrder();

        for (Creature attackerCreature : fightingCreatures) {
            if (attackerCreature.getTotalHealth() <= 0) {
                continue;
            }
            Hero attacker = attackerCreature.getOwner();
            Hero defender = attacker.equals(this.attacker) ? this.defender : this.attacker;
            Creature defenderCreature = getTarget(attackerCreature, defender);
            attack(attackerCreature, defenderCreature);
            if (defenderCreature.getTotalHealth() <= 0) {
                continue;
            }
            attack(defenderCreature, attackerCreature);

        }
    }

    private void attack(Creature attackerCreature, Creature defenderCreature) {
        int quantityAttackers = attacker.getArmy().get(attackerCreature);
        int damage = defenderCreature.takeDamage(attackerCreature.getDamage(), quantityAttackers);
        attackerCreature.setTotalHealth(attackerCreature.getTotalHealth() - damage);
        defender.getArmy().put(
                defenderCreature,
                (int)Math.floor(defenderCreature.getTotalHealth() - damage / defenderCreature.getHealth())
        );
    }

    private List<Creature> getTurnOrder() {
        // сначала я хочу создать список существ в порядке их хода, ориентируясь на скорость
        // и при одинаковой скорости на уровень героя
        List<Creature> turnOrder = new ArrayList<>();
        turnOrder.addAll(attacker.getArmy().keySet());
        turnOrder.addAll(defender.getArmy().keySet());
        turnOrder.sort((creature1, creature2) -> compareSpeedAndHeroLevel(creature1, creature2));
        return turnOrder;
    }

    private Creature getTarget(Creature attacker, Hero defender) {
        int quantityAttackers = attacker.getOwner().getArmy().get(attacker);
        int maxDamage = attacker.getAttack() * quantityAttackers;
        List<Creature> targets = new ArrayList<>();
        targets.addAll(defender.getArmy().keySet());
        targets.sort((creature1, creature2) -> {
            if (creature1.canTakeDamage(maxDamage, quantityAttackers)
                    != creature2.canTakeDamage(maxDamage, quantityAttackers)) {
                return creature1.canTakeDamage(maxDamage, quantityAttackers) ? 1 : -1;
            }
            return compareSpeedAndHeroLevel(creature1, creature2);
        });
        return targets.get(0);
    }

    private int compareSpeedAndHeroLevel(Creature creature1, Creature creature2) {
        int speedCompare = Integer.compare(creature1.getSpeed(), creature2.getSpeed());
        if (speedCompare == 0) {
            return -Integer.compare(creature1.getOwner().getLevel(), creature2.getOwner().getLevel());
        }
        return -speedCompare;
    }

    private boolean hasDeadCreature() {

    }
}
