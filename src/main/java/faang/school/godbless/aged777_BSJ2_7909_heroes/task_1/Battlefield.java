package faang.school.godbless.aged777_BSJ2_7909_heroes.task_1;

import faang.school.godbless.aged777_BSJ2_7909_heroes.task_1.creatures.Creature;

import java.util.Map;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }
    public Hero battle(Hero hero1, Hero hero2) {

        if (countSummaryDamage(hero1.getArmy()) + countSummaryDefense(hero1.getArmy()) >=
                countSummaryDamage(hero2.getArmy()) + countSummaryDefense(hero2.getArmy())) {
            return hero1;
        }

        return hero2;
    }

    private int countSummaryDamage(Map<Creature, Integer> army) {
        int summaryDamage = 0;
        for (Creature currentCreature : army.keySet()) {
            summaryDamage += currentCreature.getDefense();
        }
        return summaryDamage;
    }

    private int countSummaryDefense(Map<Creature, Integer> army) {
        int summaryDefense = 0;
        for (Creature currentCreature : army.keySet()) {
            summaryDefense += currentCreature.getDamage();
        }
        return summaryDefense;
    }
}
