package faang.school.godbless.BJS2_511;

import faang.school.godbless.BJS2_511.creatures.Creature;
import lombok.Data;
import java.util.List;
import java.util.Random;

@Data
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int power1 = powerCalculator(hero1.getArmy());
        int power2 = powerCalculator(hero2.getArmy());

        return power1 > power2 ? hero1
             : power1 < power2 ? hero2
             : new Random().nextBoolean() ? hero1 : hero2;

        /*or like this:
        if (power1 > power2) return hero1;
        if (power1 < power2) return hero2;
        return new Random().nextBoolean() ? hero1 : hero2;
        */
    }

    private int powerCalculator(List<Creature> armyList) {
        int totalPower = 0;

        for (Creature creature : armyList) {
            totalPower += creature.getDefence() + creature.getDamage();
        }

        return totalPower;
    }
}