package faang.school.godbless.geroesofmightandmagic;

import java.util.Comparator;

public class Battlefield {
    private static Hero christian = new Hero("Christian", "Allince", 0, 1);
    private static Hero calh = new Hero("Calh", "Demon", 0, 1);

    private static int round;

    public static void main(String[] args) {
        christian.addCreature(new Pikeman("Pikeman"), 45);
        christian.addCreature(new Griffin("Griffin"), 26);
        christian.addCreature(new Swordman("Swordman"), 16);
        christian.addCreature(new Angel("Angel"), 13);

        calh.addCreature(new Pikeman("Pikeman"), 50);
        calh.addCreature(new Griffin("Griffin"), 20);
        calh.addCreature(new Swordman("Swordman"), 19);
        calh.addCreature(new Angel("Angel"), 11);

        sortArmyBySpeed();

        System.out.println("Test getArmy:");
        christian.printArmy();
        calh.printArmy();
        System.out.println("-------------------");
        System.out.println();

        System.out.println("Winner: " + battle().getName());
    }

    public static Hero battle() {
        while (true) {
            System.out.println("Round " + ++round + ":");
            Creature calhCreature;
            Creature christianCreature;

            if (!calh.getArmy().isEmpty() && !christian.getArmy().isEmpty()) {
                calhCreature = calh.getArmy().get(0);
                christianCreature = christian.getArmy().get(0);

                System.out.println("Calh attack...");
                attack(calh, christian, calhCreature, christianCreature);
            } else {
                break;
            }

            if (!calh.getArmy().isEmpty() && !christian.getArmy().isEmpty()) {
                calhCreature = calh.getArmy().get(0);
                christianCreature = christian.getArmy().get(0);

                System.out.println("Christian attack...");
                attack(christian, calh, christianCreature, calhCreature);
            } else {
                break;
            }

            System.out.println("Heroes army after " + round + " round");
            christian.printArmy();
            calh.printArmy();
        }
        return christian.getArmy().isEmpty() ? calh : christian;
    }

    public static void attack(Hero attacker, Hero defender, Creature attackerCreature, Creature defenderCreature) {
        int exp = defender.removeCreature(defenderCreature,
                attackerCreature.getDamage() - defenderCreature.getDamageReduction());

        System.out.println(attacker.getName() + " gained " + exp + " experience");
        attacker.setExperience(exp);
    }

    public static void sortArmyBySpeed() {
        Comparator<Creature> comparator = (o1, o2) -> o2.getSpeed() - o1.getSpeed();

        christian.getArmy().sort(comparator);
        calh.getArmy().sort(comparator);
    }

}
