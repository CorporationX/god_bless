package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Battlifild {
    private Battlifild() {

    }

    public static void battle(Hero heroFirst, Hero heroSecond) {
        int result = heroFight(heroFirst, heroSecond);
        List<Creature> armyFirstHero = new ArrayList<>(heroFirst.getArmy().keySet());
        List<Creature> armySecondHero = new ArrayList<>(heroSecond.getArmy().keySet());
        List<Integer> countFirstArmy = new ArrayList<>(heroFirst.getArmy().values());
        List<Integer> countSecondArmy = new ArrayList<>(heroSecond.getArmy().values());
        for (int i = 0; i < heroFirst.getArmy().keySet().size(); i++) {
            result += petBattle(armyFirstHero.get(i), countFirstArmy.get(i),
                    armySecondHero.get(i), countSecondArmy.get(i));
        }
        resultBattle(result);

    }

    private static int petBattle(Creature creatureFirstHero, Integer countArmyFirstHero,
                                 Creature creatureSecondHero, Integer countArmySecondHero) {
        int petHealsHeroFirst = creatureFirstHero.peekNumber * countArmyFirstHero;
        int petHealsHeroSecond = creatureSecondHero.peekNumber * countArmySecondHero;
        int result = 0;
        while (petHealsHeroSecond <= 0 && petHealsHeroFirst <= 0) {
            int randomNumber = (int) (Math.random() * 2.1);
            switch (randomNumber) {
                case 1 -> petHealsHeroSecond -= creatureFirstHero.getDamage() * countArmyFirstHero;
                case 2 -> petHealsHeroFirst -= creatureSecondHero.getDamage() * countArmySecondHero;
            }
        }
        if (petHealsHeroFirst <= 0) {
            result += 1;
        } else {
            result -= 1;
        }
        return result;
    }

    private static int heroFight(Hero heroFirst, Hero heroSecond) {
        if (heroSecond.getLevel() > heroSecond.getLevel()) {
            return 1;
        } else {
            return -1;
        }
    }

    private static void resultBattle(int result) {
        if (result > 0) {
            System.out.println("FirstHero win");
        } else {
            System.out.println("SecondHero win");
        }
    }
}
