package faang.school.godbless.geroesofmightandmagic;

import java.util.Comparator;

public class Battlefield {
    private final static Hero CHRISTIAN = new Hero("Christian", "Allince", 0, 1);
    private final static Hero CALH = new Hero("Calh", "Demon", 0, 1);
    private final static Comparator<Creature> SPEED_COMPARATOR = (o1, o2) -> o2.getSpeed() - o1.getSpeed();

    private static int round;

    public static void main(String[] args) {
        CHRISTIAN.addCreature(new Pikeman("Pikeman"), 45);
        CHRISTIAN.addCreature(new Griffin("Griffin"), 26);
        CHRISTIAN.addCreature(new Swordman("Swordman"), 16);
        CHRISTIAN.addCreature(new Angel("Angel"), 13);

        CALH.addCreature(new Pikeman("Pikeman"), 50);
        CALH.addCreature(new Griffin("Griffin"), 20);
        CALH.addCreature(new Swordman("Swordman"), 19);
        CALH.addCreature(new Angel("Angel"), 11);

        sortArmyBySpeed();

        System.out.println("Test getArmy:");
        CHRISTIAN.printArmy();
        CALH.printArmy();
        System.out.println("-------------------");
        System.out.println();

        System.out.println("Winner: " + battle().getName());
    }

    public static Hero battle() {
        boolean result = true;
        while (result) {
            System.out.println("Round " + ++round + ":");

            System.out.println("Calh attack...");
            result = attack(CALH, CHRISTIAN);

            System.out.println("Christian attack...");
            result = attack(CHRISTIAN, CALH);

            System.out.println("Heroes army after " + round + " round");
            CHRISTIAN.printArmy();
            CALH.printArmy();
        }
        return CHRISTIAN.getArmy().isEmpty() ? CALH : CHRISTIAN;
    }

    public static boolean attack(Hero attacker, Hero defender) {
        Creature attackerCreature = preparingForBattle(attacker);
        Creature defenderCreature = preparingForBattle(defender);
        if (attackerCreature == null || defenderCreature == null) {
            System.out.println("All creatures died");
            return false;
        }
        int exp = defender.removeCreature(
                defenderCreature, attackerCreature.getDamage() - defenderCreature.getDamageReduction()
        );

        System.out.println(attacker.getName() + " gained " + exp + " experience");
        attacker.setExperience(exp);
        return true;
    }

    public static Creature preparingForBattle(Hero hero) {
        if (!hero.getArmy().isEmpty()) {
            return hero.getArmy().get(0);
        }
        return null;
    }

    public static void sortArmyBySpeed() {
        CHRISTIAN.getArmy().sort(SPEED_COMPARATOR);
        CALH.getArmy().sort(SPEED_COMPARATOR);
    }
}
