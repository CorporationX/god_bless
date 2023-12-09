package faang.school.godbless.javaHashMap.heroesMightAndMagic;

import java.util.List;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle() {
        List<Creature> army1 = firstHero.getArmy();
        List<Creature> army2 = secondHero.getArmy();

        while (army1.size() != 0 && army2.size() != 0) {
            int damageFirstHero = army1.get(0).getDamage();
            int damageSecondHero = army2.get(0).getDamage();
            if (damageFirstHero > damageSecondHero) {
                army2.remove(0);
            } else {
                army1.remove(0);
            }
        }

        if (army1.size() == 0) {
            return secondHero;
        } else {
            return firstHero;
        }
    }
}
