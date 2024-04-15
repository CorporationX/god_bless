package faang.school.godbless.hashMap.task_7.model;

import faang.school.godbless.hashMap.task_7.model.creatures.Creature;
import faang.school.godbless.hashMap.task_7.model.heroes.Hero;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class BattleField {
    private static final Random RANDOM = new Random();
    private final Hero attacker;
    private final Hero defender;

    public void battle() {
        while (!isWin()) {
            if (RANDOM.nextBoolean()) {
                System.out.println("Ход героя " + attacker);
                startAttack(attacker, defender);
            } else {
                System.out.println("Ход героя " + defender);
                startAttack(defender, attacker);
            }
        }
        System.out.println(attacker.isDefeated() ? " победил " + defender : "победил" + attacker);
    }

    private boolean isWin() {
        return attacker.isDefeated() || defender.isDefeated();
    }

    private Creature selectCreature(Hero hero) {
        List<Creature> armyOfHero = hero.getArmy();
        return armyOfHero.get(RANDOM.nextInt(0, armyOfHero.size()));
    }

    private void startAttack(Hero attackingHero, Hero defendingHero) {
        Creature attackingUnit;
        Creature defendingUnit;
        attackingUnit = selectCreature(attackingHero);
        defendingUnit = selectCreature(defendingHero);
        int killedCreatures = attackingUnit.attack(defendingUnit);
        defendingHero.removeCreature(defendingUnit, killedCreatures);
    }
}