package faang.school.godbless.BJS2_511;

import faang.school.godbless.BJS2_511.creatures.Creature;
import lombok.Data;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

@Data
public class Battlefield {
    private static final double COEFFICIENT = 0.5;
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        System.out.println("Fight is started!");

        double power1 = pointsCalc();

        return power1 > 0 ? hero1
                : power1 < 0 ? hero2
                : new Random().nextBoolean() ? hero1 : hero2;
    }

    private double pointsCalc() {

        double overPoints = hero1.getArmyMap().entrySet().size() - hero2.getArmyMap().entrySet().size();
        double battlePoints = 0;

        Iterator<Map.Entry<Creature, Integer>> army1Iterator = hero1.getArmyMap().entrySet().iterator();
        Iterator<Map.Entry<Creature, Integer>> army2Iterator = hero2.getArmyMap().entrySet().iterator();

        while (army1Iterator.hasNext() && army2Iterator.hasNext()) {
            System.out.println("-----------------------------------------------");

            Map.Entry<Creature, Integer> unit1 = army1Iterator.next();
            Map.Entry<Creature, Integer> unit2 = army2Iterator.next();

            double power1 = unit1.getKey().getPower() * unit1.getValue(); //creature power * quantity
            double power2 = unit2.getKey().getPower() * unit2.getValue();

            boolean isFirstWinner = power1 > power2;
            double powerRatio = isFirstWinner ? power1 / power2 : power2 / power1;

            System.out.println("Unit of " + hero1.getName() + ": " + unit1);
            System.out.println("Unit of " + hero2.getName() + ": " + unit2);

            if (powerRatio != 1) {
                if (isFirstWinner) {
                    System.out.println("Unit of " + hero1.getName() + " won!");
                    battlePoints += powerRatio;
                    handleWinnerAndLoser(unit1, unit2, army2Iterator, powerRatio);
                } else {
                    System.out.println("Unit of " + hero2.getName() + " won!");
                    battlePoints -= powerRatio;
                    handleWinnerAndLoser(unit2, unit1, army1Iterator, powerRatio);
                }
            }
            System.out.println("-----------------------------------------------");
        }
        System.out.println("Battle points: " + battlePoints);
        System.out.println("Points of quantity: " + overPoints);
        return battlePoints + overPoints;
    }

    private void handleWinnerAndLoser(Map.Entry<Creature, Integer> winnerUnit, Map.Entry<Creature, Integer> loserUnit
            , Iterator<Map.Entry<Creature, Integer>> loserIterator, double k) {

        winnerAfterFight(winnerUnit, k);
        if (1 / k < COEFFICIENT) {
            loserIterator.remove();
            System.out.println("Loser unit was removed! :(");
            return;
        }
        loserAfterFight(loserUnit, k);
    }

    private void winnerAfterFight(Map.Entry<Creature, Integer> winnerUnit, double k) {
        changeFighter(winnerUnit, 1 - 1 / k);
        System.out.println("Winner unit after fight: " + winnerUnit);
    }

    private void loserAfterFight(Map.Entry<Creature, Integer> loserUnit, double k) {
        changeFighter(loserUnit, 1 / k);
        System.out.println("Loser unit after fight: " + loserUnit);
    }

    private void changeFighter(Map.Entry<Creature, Integer> unit, double k) {
        // if winner has x5 power, it will be 1 - 1 / 5 = 0,8 -> 80%. 80% of quantity and 20% increase of lvl.
        int newQuantity = (int) (unit.getKey().getQuantity() * k); //reduce quantity
        unit.getKey().setQuantity(newQuantity);

        int winnerLvl = (int) (unit.getKey().getLevel() * (1 + k)); //increase lvl
        unit.getKey().setLevel(winnerLvl);
    }
}