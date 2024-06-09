package faang.school.godbless.module1.sprint1.task8;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {


    public static void battle(Hero heroFirst, Hero heroSecond) {
        int result = heroFight(heroFirst, heroSecond);
        List<Creature> armyFitsHero = new ArrayList<>(heroFirst.getArmy().keySet());
        List<Creature> armySecondHero = new ArrayList<>(heroSecond.getArmy().keySet());
        List<Integer> countOfPetsFirstHero = new ArrayList<>(heroFirst.getArmy().values());
        List<Integer> countOfPetsSecondHero = new ArrayList<>(heroSecond.getArmy().values());
        for (int i = 0; i < heroFirst.getArmy().keySet().size(); i++) {
            result += petBattle(armyFitsHero.get(i),
                    countOfPetsFirstHero.get(i),
                    armySecondHero.get(i),
                    countOfPetsSecondHero.get(i));
        }
        printResult(result);
    }

    private static int petBattle(Creature petFirstHero,
                                 Integer countOfPetFirstHero,
                                 Creature petSecondHero,
                                 Integer countOfPetSecondHero) {
        int petHealsHeroFirst = petFirstHero.heals * countOfPetFirstHero;
        int petHealsHeroSecond = petSecondHero.heals * countOfPetSecondHero;
        int result = 0;
        while (petHealsHeroSecond <= 0 && petHealsHeroFirst <= 0) {
            int randomNumber = (int) (Math.random() * 2.1);
            switch (randomNumber) {
                case 1 -> petHealsHeroSecond -= petFirstHero.getDamage()
                        * countOfPetFirstHero - petSecondHero.defense;
                case 2 -> petHealsHeroFirst -= petSecondHero.getDamage()
                        * countOfPetSecondHero - petFirstHero.defense;
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
        if (heroFirst.getLvl() > heroSecond.getLvl()) {
            return 1;
        } else {
            return -1;
        }
    }

    private static void printResult(int result) {
        if (result > 0) {
            System.out.println("FirstHero win");
        } else {
            System.out.println("SecondHero win");
        }
    }


}
