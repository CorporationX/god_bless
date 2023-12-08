package faang.school.godbless.heroesOfMandM;

import java.util.List;

public class Battlefield {
    Hero firstHero;
    Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    Hero battle() {
        List<Creature> army1 = firstHero.getArmy();
        List<Creature> army2 = secondHero.getArmy();

        while (true) {
            (getAttackItem(army1)).getDamage(getAttackItem(army2));
            if (getAttackItem(army1) == null) {
                return secondHero;
            }
            (getAttackItem(army2)).getDamage(getAttackItem(army1));
            if (getAttackItem(army2) == null) {
                return firstHero;
            }
        }
    }

    private Creature getAttackItem(List<Creature> armyHero) {
        for (Creature creature : armyHero) {
            if (creature.getAmount() > 0) {
                return creature;
            }
        }
        return null;
    }
}