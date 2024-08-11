package faang.school.godbless.javahashmap.herouse;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Battlefield {

    private Hero hero1;
    private Hero hero2;

    public void battle() {
        System.out.println("Stats:");
        printStats();
        int roundCounter = 0;

        while (hero1.hasArmy() && hero2.hasArmy()) {
            System.out.println("\n=== Round " + ++roundCounter + " ===");

            Map.Entry<Creature, Integer> troopOfHero1 = hero1.getRandomCreature();
            Map.Entry<Creature, Integer> troopOfHero2 = hero2.getRandomCreature();

            fight(hero1, troopOfHero1, hero2, troopOfHero2);

            if (!hero2.hasArmy()) {
                break;
            }

            fight(hero2, troopOfHero2, hero1, troopOfHero1);
        }

        if (!hero1.hasArmy()) {
            System.out.println("\nHero " + hero2.getName() + " wins!");
        } else {
            System.out.println("\nHero " + hero1.getName() + " wins!");
        }
    }

    private void fight(Hero attackHero, Map.Entry<Creature, Integer> attackTroop,
                       Hero defenceHero, Map.Entry<Creature, Integer> defenceTroop) {

        Creature attackCreature = attackTroop.getKey();
        int quantityOfAttackCreature = attackTroop.getValue();

        Creature defenceCreature = defenceTroop.getKey();
        int quantityOfDefenceCreature = defenceTroop.getValue();

        System.out.println(
                "\nHero " + attackHero.getName() + " with creature " + attackCreature.getName() + ", quantity " + quantityOfAttackCreature + " attacks "
                        + "Hero " + defenceHero.getName() + " with creature " + defenceCreature.getName() + ", quantity " + quantityOfDefenceCreature);

        int sumDamageCreature1 = attackCreature.getDamage() * quantityOfAttackCreature;
        int sumHpCreature2 = defenceCreature.getHp() * quantityOfDefenceCreature;

        if (sumDamageCreature1 >= sumHpCreature2) {
            defenceHero.removeCreature(defenceCreature, quantityOfDefenceCreature);
        } else {
            defenceHero.removeCreature(defenceCreature, sumDamageCreature1 / defenceCreature.getHp());
        }

        System.out.println("Result of fight:");
        printStats();
    }

    private void printStats() {
        System.out.println("    hero1 " + hero1.getName() + ": " + hero1.getArmy() + "\n"
                + "    hero2 " + hero2.getName() + ": " + hero2.getArmy());
    }
}
