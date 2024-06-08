package faang.school.godbless.BJS27979;

import faang.school.godbless.BJS27979.Creatures.Creature;

import java.util.ArrayList;
import java.util.List;


public class Battlefield {
    private Hero goodHero;
    private Hero badHero;

    public void getBattle() {
        System.out.println("\nSTART FIGHTING!\n");
        int round = 1;
        while (checkLooser() == 0) {
            System.out.println("\nRound " + round + "\n");
            fightRound();
            round++;
        }
        if (checkLooser() == 1) {
            System.out.println("\nFINISH FIGHTING!\n" + badHero.getName() + " WIN!");
        } else {
            System.out.println("\nFINISH FIGHTING!\n" + goodHero.getName() + " WIN!");
        }
    }
    public void fightRound() {
        List<Creature> fightingCreatures = getTurnOrder();

        for (Creature attackerCreature : fightingCreatures) {
            Hero attackerHero = attackerCreature.getOwner();
            Hero defenderHero = attackerHero.equals(this.goodHero) ? this.badHero : this.goodHero;
            Creature defenderCreature = getTarget(attackerCreature, defenderHero);

            System.out.println("\nattack!\n");
            attack(attackerCreature, defenderCreature);
            if (defenderCreature.getTotalHealth() != 0) {
                System.out.println("\ncounterattack!\n");
                attack(defenderCreature, attackerCreature);
            }
        }
    }

    private void attack(Creature attackerCreature, Creature defenderCreature) {
        int lostUnits = defenderCreature.getQuantity();
        int lostHP = defenderCreature.getTotalHealth();
        System.out.println(attackerCreature.getQuantity() + " " + attackerCreature.getName() +
                " attacks " + defenderCreature.getQuantity() + " " + defenderCreature.getName());
        defenderCreature.takeDamage(attackerCreature);
        lostUnits -= defenderCreature.getQuantity();
        lostHP -= defenderCreature.getTotalHealth();
        System.out.println(defenderCreature.getName() + " lost " + lostHP + "HP, what means " +
                lostUnits + " units. And now it's: " + defenderCreature.getQuantity());
    }

    private List<Creature> getTurnOrder() {
        // сначала я хочу создать список существ в порядке их хода, ориентируясь на скорость
        // и при одинаковой скорости на уровень героя
        List<Creature> turnOrder = new ArrayList<>();
        turnOrder.addAll(goodHero.getArmy());
        turnOrder.addAll(badHero.getArmy());
        turnOrder.sort(this::compareSpeedAndHeroLevel);
        return turnOrder;
    }

    private Creature getTarget(Creature attacker, Hero defender) {
        List<Creature> targets = new ArrayList<>();
        targets.addAll(defender.getArmy());
        targets.sort((creature1, creature2) -> {
            if (creature1.canTakeDamage(attacker)
                    != creature2.canTakeDamage(attacker)) {
                return creature1.canTakeDamage(attacker) ? 1 : -1;
            }
            return compareSpeedAndHeroLevel(creature1, creature2);
        });
        return targets.get(0);
    }

    private int compareSpeedAndHeroLevel(Creature creature1, Creature creature2) {
        int speedCompare = -Integer.compare(creature1.getSpeed(), creature2.getSpeed());
        if (speedCompare == 0) {
            return -Integer.compare(creature1.getOwner().getLevel(), creature2.getOwner().getLevel());
        }
        return speedCompare;
    }

    private int checkLooser() {
        if (goodHero.checkLoose()) {
            return 1;
        } else if (badHero.checkLoose()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Battlefield(Hero goodHero, Hero badHero) {
        if (goodHero.getArmy().size() == 0 && badHero.getArmy().size() == 0) {
            System.out.println("Unfortunately, both heroes haven't army's");
        } else if (goodHero.getArmy().size() == 0) {
            System.out.println("Unfortunately, " + goodHero.getName() + " hasn't army");
        } else if (badHero.getArmy().size() == 0) {
            System.out.println("Unfortunately, " + badHero.getName() + " hasn't army");
        } else {
            this.goodHero = goodHero;
            this.badHero = badHero;
        }
    }
}
