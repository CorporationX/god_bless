package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Event {
    private static Hero firstHero;
    private static Hero secondHero;

    public static Hero getFirstHero() {
        return firstHero;
    }

    public static Hero getSecondHero() {
        return secondHero;
    }

    public static void initHero() {
        firstHero = new Hero("Axe", "Dire", 0, 1);
        initArmy(firstHero);
        secondHero = new Hero("Urse", "Radiant", 0, 1);
        initArmy(secondHero);
    }

    public static void initArmy(Hero hero) {
        hero.addCreature(new Pikeman());
        hero.addCreature(new Griffin());
        hero.addCreature(new Swordman());
        hero.addCreature(new Angel());
    }

    public static void raiseTheTroops(Hero hero) {
        for (Creature creature : hero.getArmyHero()) {
            if (creature.getName().equals("Pikeman")) {
                creature.setQuality(creature.getQuality() + 7);
            }
            if (creature.getName().equals("Swordman")) {
                creature.setQuality(creature.getQuality() + 4);
            }
        }
        System.out.println("Господин! Мы созвали новых воинов!");
        System.out.println("Прибыли новые войска! \n" + "Pikemen: 7  \n" + "Swordman: 4");
    }

    public static void attackOfTheNatives(Hero hero) {
        for (Creature creature : hero.getArmyHero()) {
            if (creature.getName().equals("Pikeman")) {
                creature.setQuality(creature.getQuality() - 4);
            }
            if (creature.getName().equals("Swordman")) {
                creature.setQuality(creature.getQuality() - 2);
            }
            if (creature.getName().equals("Griffin")) {
                creature.setQuality(creature.getQuality() - 1);
            }
        }
        System.out.println("На нас напали местные племена!");
        System.out.println("Потери: \n Pikeman: 4 \n" + "Swordman: 2 \n" + "Griffin: 1");
    }

    public static void goodSupply(Hero hero) {
        for (Creature creature : hero.getArmyHero()) {
            creature.setSpeed(creature.getSpeed() + 1);
        }
        System.out.println("Хорошее снабжение! \n Войска передвигаются быстрее на 1");
    }

    public static void poorSupply(Hero hero) {
        for (Creature creature : hero.getArmyHero()) {
            creature.setSpeed(creature.getSpeed() - 1);
        }
        System.out.println("Плохое снабжение! \n Войска передвигаются медленнее на 1");
    }

    public static void visitTheForge(Hero hero) {
        for (Creature creature : hero.getArmyHero()) {
            creature.setArmor(creature.getArmor() + 4);
        }
        System.out.println("Кузнец улучшил наши доспехи! \n Броня всей армии увеличилась на 4");
    }

    public static void inspiration(Hero hero) {
        for (Creature creature : hero.getArmyHero()) {
            creature.setAttack(creature.getAttack() + 3);
        }
        System.out.println("Войка воодушевлены! \n Атака всей армии увеличилась на 3");
    }

    public static void lossOfMorale(Hero hero) {
        for (Creature creature : hero.getArmyHero()) {
            creature.setAttack(creature.getAttack() - 2);
        }
        System.out.println("Войка пали духом! \n Атака всей армии уменьшилась на 2");
    }
}
