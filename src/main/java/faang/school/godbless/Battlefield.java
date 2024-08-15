package faang.school.godbless;

import java.util.Map;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int hero1Damage = calculateTotalDamage(hero1);
        int hero2Damage = calculateTotalDamage(hero2);

        if (hero1Damage > hero2Damage) {
            return hero1;
        } else if (hero2Damage > hero1Damage) {
            return hero2;
        } else {
            return null;
        }
    }

    private int calculateTotalDamage(Hero hero) {
        int totalDamage = 0;
        for (Map.Entry<Creature, Integer> entry : hero.getArmy().entrySet()) {
            Creature creature = entry.getKey();
            totalDamage += (creature.getDemage() * entry.getValue());
        }
        return totalDamage;
    }
}
