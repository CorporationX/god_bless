package faang.school.godbless.BJS2_18932;

import java.util.Map;
import java.util.Random;

public class Battlefield {
    private Hero protagonist;
    private Hero antagonist;

    public Battlefield(Hero protagonist, Hero antagonist) {
        this.protagonist = protagonist;
        this.antagonist = antagonist;
    }

    private int calculateArmyDamage(Hero hero) {
        int totalDamage = 0;
        Map<Creature, Integer> army = hero.getArmy();
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            Creature creature = entry.getKey();
            int creatureDamage = creature.getDamage();
            totalDamage += creatureDamage;
        }
        return totalDamage;
    }

    private int calculateArmyDefence(Hero hero) {
        int totalDefence = 0;
        Map<Creature, Integer> army = hero.getArmy();
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            Creature creature = entry.getKey();
            int creatureDefence = creature.getDamage();
            totalDefence += creatureDefence;
        }
        return totalDefence;
    }

    private int calculateArmyLvl(Hero hero) {
        int totalLvl = hero.getLvl();
        Map<Creature, Integer> army = hero.getArmy();
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            Creature creature = entry.getKey();
            int creatureLvl = creature.getDamage();
            totalLvl += creatureLvl;
        }
        return totalLvl;
    }

    private int compareByBattle(Hero heroOne, Hero heroTwo) {
        return (calculateArmyDefence(heroOne) - calculateArmyDamage(heroTwo) - (calculateArmyDefence(heroTwo) - calculateArmyDamage(heroOne)));
    }

    private int compareByArmyLvl(Hero heroOne, Hero heroTwo) {
        return calculateArmyLvl(heroOne) - calculateArmyLvl(heroTwo);
    }

    private int compareByHeroExp(Hero heroOne, Hero heroTwo) {
        return heroOne.getExp() - heroTwo.getExp();
    }

    public Hero battle() {
        if (compareByBattle(protagonist, antagonist) > 0) {
            return protagonist;
        } else if (compareByBattle(protagonist, antagonist) < 0) {
            return antagonist;
        } else {
            if (compareByArmyLvl(protagonist, antagonist) > 0) {
                return protagonist;
            } else if (compareByArmyLvl(protagonist, antagonist) < 0) {
                return antagonist;
            } else {
                if (compareByHeroExp(protagonist, antagonist) > 0) {
                    return protagonist;
                } else if (compareByHeroExp(protagonist, antagonist) < 0) {
                    return antagonist;
                } else {
                    Random random = new Random();
                    return (random.nextInt() % 2 == 0) ? protagonist : antagonist;
                }
            }
        }
    }
}