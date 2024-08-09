package faang.school.godbless.task.might.and.magic.hero;

import faang.school.godbless.task.might.and.magic.creature.Creature;

import java.util.List;

public class Battlefield {

    public Hero battle(Hero heroA, Hero heroB) {
        List<Creature> armyOfHeroA = heroA.getArmy();
        int damageOfHeroA = 0, healthOfHeroA = 0;
        for (Creature creature : armyOfHeroA) {
            damageOfHeroA += creature.getDamage();
            healthOfHeroA += creature.getHealth();
        }

        List<Creature> armyOfHeroB = heroB.getArmy();
        int damageOfHeroB = 0, healthOfHeroB = 0;
        for (Creature creature : armyOfHeroB) {
            damageOfHeroB += creature.getDamage();
            healthOfHeroB += creature.getHealth();
        }
        healthOfHeroA -= damageOfHeroB;
        healthOfHeroB -= damageOfHeroA;

        return healthOfHeroA > healthOfHeroB ? heroA : heroB;
    }
}
