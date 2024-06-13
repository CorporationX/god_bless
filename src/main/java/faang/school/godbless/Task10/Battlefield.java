package faang.school.godbless.Task10;

import java.util.List;
import java.util.ArrayList;

public class Battlefield {

    public static int overallDamage(Hero hero) {;
        int additionalDamage = hero.getLevel();
        for (Creature creature : hero.getArmy()) {
            additionalDamage =  creature.getDamage()*(creature.getLevel()+creature.getQuantity()) + additionalDamage;
        }
        return additionalDamage;
    }
    public static int overallHealth(Hero hero) {
        int additionalHealth = hero.getExp();
        for (Creature creature : hero.getArmy()) {
            additionalHealth = creature.getQuantity()*(25 + creature.getDefense()) + additionalHealth;
        }
        return additionalHealth;
    }

    public static Hero battle(Hero one, Hero two) {
        Boolean oneIsAlive = true;
        Boolean twoIsAlive = true;
        int totalHealthOne = overallHealth(one);
        int totalHealthTwo = overallHealth(two);
        int totalDamageOne = overallDamage(one);
        int totalDamageTwo = overallDamage(two);
        System.out.println("Hero " + one.getName() + "attacked hero " + two.getName());
        while (oneIsAlive && twoIsAlive) {
            totalHealthOne = totalHealthOne - totalDamageTwo;
            totalHealthTwo = totalHealthTwo - totalDamageOne;
            System.out.println("Remaining health of 1st hero is " + totalHealthOne);
            System.out.println("Remaining health of 2nd hero is " + totalHealthTwo);
            if (totalHealthOne <= 0) {
                oneIsAlive = false;
                break;
            }
            if (totalHealthTwo <= 0) {
                twoIsAlive = false;
            }
        }
        System.out.println("The battle is over!");
        if (oneIsAlive) {
            System.out.println("The attacker(" + one.getName() + ") has won!");
            return one;
        } else {
            System.out.println("The defender(" + two.getName() + ") has won");
            return two;
        }
    }

    public static void main(String[] args) {

        Creature orcs = new Pikerman("Orcs");
        Creature goblins = new Swordman("Goblins");
        Creature shamans = new Angel("Shamans");
        List<Creature> thrallArmy = new ArrayList<>();
        thrallArmy.add(orcs);
        thrallArmy.add(goblins);
        thrallArmy.add(shamans);
        Hero thrall = new Hero("Thrall", "Horde", 75, 10, thrallArmy);
        Creature newOrcs = new Pikerman("Orcs");
        thrall.addToArmy(newOrcs,1);
        Creature footmen = new Swordman("Footmen");
        Creature griffins = new Griffin("Griffins");
        Creature priests = new Angel("Priests");
        List<Creature> anduinArmy = new ArrayList<>();
        anduinArmy.add(footmen);
        anduinArmy.add(griffins);
        anduinArmy.add(priests);
        Hero anduin = new Hero("Anduin", "Alliance", 60, 12, anduinArmy);
        Creature newFootmen = new Swordman("Footmen");
        anduin.addToArmy(newFootmen, 1);
        battle(thrall, anduin);

    }

}
