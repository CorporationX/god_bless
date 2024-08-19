package faang.school.godbless.heroes;

import java.util.List;

public class Battlefield {
    private final Hero hero1;
    private final Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }


    public Hero battle() {
        int totalDamageHero1 = calculateTotalDamage(hero1.getArmy());
        int totalDamageHero2 = calculateTotalDamage(hero2.getArmy());

        if (totalDamageHero1 > totalDamageHero2) {
            return hero1;
        }
        if (totalDamageHero2 > totalDamageHero1) {
            return  hero2;
        }
        return null;
    }

    private int calculateTotalDamage(List<Creature> army) {
        int totalDamage = 0;
        for (Creature creature : army) {
            totalDamage += creature.getDamage();
        }
        return totalDamage;
    }
}
