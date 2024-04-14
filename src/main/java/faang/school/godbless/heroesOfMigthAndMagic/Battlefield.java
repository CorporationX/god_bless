package faang.school.godbless.heroesOfMigthAndMagic;

public class Battlefield {
    private static Hero heroOne;
    private static Hero heroTwo;

    public static void main(String[] args) {
        heroOne = new Hero("Mark", "Alliance", 0, 1);
        heroTwo = new Hero("Harry", "Imperial", 0, 1);

        heroOne.addCreature(new Angel(), 10);
        heroOne.addCreature(new Swordsman(), 10);
        heroOne.addCreature(new Pikeman(), 10);
        heroOne.addCreature(new Griffin(), 10);

        heroTwo.addCreature(new Angel(), 20);
        heroTwo.addCreature(new Swordsman(), 20);
        heroTwo.addCreature(new Pikeman(), 10);

        System.out.println("---------Before battle-------");
        heroOne.printArmy();
        heroTwo.printArmy();
        System.out.println("The winner in this battle is :" + battle().getName());
        System.out.println("---------After battle-------");
        heroOne.removeCreature(new Angel(), 6);
        heroOne.printArmy();
        heroTwo.addCreature(new Pikeman(), 15);
        heroTwo.printArmy();
    }

    public static Hero battle() {
        double armyOneDamage = calculateArmyDamage(heroOne);
        double armyTwoDamage = calculateArmyDamage(heroTwo);
        double armyOneDefence = calculateArmyDefence(heroOne);
        double armyTwoDefence = calculateArmyDefence(heroTwo);
        if (armyOneDamage - armyTwoDefence > armyTwoDamage - armyOneDefence) {
            afterBattle(heroTwo, 0.5);
            afterBattle(heroOne, 0.9);
            return heroOne;
        } else {
            afterBattle(heroTwo, 0.9);
            afterBattle(heroOne, 0.5);
            return heroTwo;
        }
    }

    public static double calculateArmyDamage(Hero hero) {
        double armyDamage = 0;
        for (Creature heroCreature : hero.getArmy().keySet()) {
            armyDamage += hero.getArmy().get(heroCreature) * heroCreature.getDamage();
        }
        return armyDamage;
    }

    public static double calculateArmyDefence(Hero hero) {
        double armyDefence = 0;
        for (Creature heroCreature : hero.getArmy().keySet()) {
            armyDefence += hero.getArmy().get(heroCreature) * heroCreature.getDefence();
        }
        return armyDefence;
    }

    public static void afterBattle(Hero hero, double punishFactor) {
        hero.getArmy().forEach((creature, quantity) -> hero.getArmy().put(creature, (int) (quantity * punishFactor)));
    }

}
