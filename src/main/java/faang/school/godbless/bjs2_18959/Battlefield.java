package faang.school.godbless.bjs2_18959;

import faang.school.godbless.bjs2_18959.creatures.Creature;

import java.util.List;
import java.util.Random;

public class Battlefield {
    private Hero leftHero;
    private Hero rightHero;
    private Random random;

    // leftHero always attacks the first
    public Battlefield(Hero leftHero, Hero rightHero) {
        this.leftHero = leftHero;
        this.rightHero = rightHero;
        random = new Random();
    }

    public Hero battle() {
        int i = 0;
        while (leftHero.isAlive() && rightHero.isAlive()) {
            if (i % 2 == 0) {
                attack(leftHero, rightHero);
            } else {
                attack(rightHero, leftHero);
            }
            i++;
        }

        return leftHero.isAlive() ? leftHero : rightHero;
    }

    private void attack(Hero attacker, Hero defender) {
        var attackerArmy = attacker.getArmy();
        var defenderArmy = defender.getArmy();

        var attackerCreature = getRandomCreatureForFight(attackerArmy);
        var defenderCreature = getRandomCreatureForFight(defenderArmy);
        attackerCreature.attack(defenderCreature);

        defender.removeIfDead(defenderCreature);
    }

    private Creature getRandomCreatureForFight(List<Creature> creatures) {
        if (creatures.size() == 1) {
            return creatures.get(0);
        }

        int randomCreatureNumber = random.nextInt(creatures.size() - 1);
        return creatures.get(randomCreatureNumber);
    }
}
