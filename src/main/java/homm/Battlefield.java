package homm;

import homm.creatures.Creature;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battlefield {
    public static void battle(@NonNull Hero firstHero, @NonNull Hero secondHero) {
        printBattleIntroduction(firstHero.getName(), secondHero.getName());
        var result = executeBattle(firstHero, secondHero);
        handleResult(result, firstHero, secondHero);
    }

    private static int doTurn(@NonNull Hero attacker, @NonNull Hero defender) {
        System.out.println("\nHero " + attacker.getName() + " is attacking!");
        System.out.println("Attack of hero: " + attacker.getDamage());
        System.out.println("Defense of enemy: " + defender.getDefense());
        int finalDamage = attacker.getDamage() - defender.getDefense();
        int successAttack = 0;
        if (finalDamage > 0) {
            successAttack = attackOnArmy(finalDamage, defender);
        } else {
            System.out.println("Defense of the enemy is too strong!");
        }

        return successAttack;
    }

    private static int attackOnArmy(int finalDamage, @NonNull Hero hero) {
        Random rand = new Random();
        List<Creature> listOfCreatures = new ArrayList<>(hero.getCreatures().keySet());
        Creature target = listOfCreatures.get(rand.nextInt(listOfCreatures.size()));
        int countToKill = (int) Math.round((Math.ceil(finalDamage * 1.0 / target.getHealth())));
        var creatures = hero.getCreatures();
        if (creatures.get(target) < countToKill) {
            countToKill = creatures.get(target);
        }
        if (countToKill > 0) {
            hero.removeCreature(target, countToKill);
            int exp = countToKill * target.getLevel() * target.getHealth();
            System.out.println(
                    "Oof! Army of Hero " + hero.getName() + " lost " + countToKill + " " + target.getName());
            return exp;
        } else {
            System.out.println("This weak attack is not enough to kill someone!");
            return 0;
        }
    }

    private static void printBattleIntroduction(@NonNull String firstHeroName, @NonNull String secondHeroName) {
        System.out.println(
                "\nThe battle between Hero " + firstHeroName + " of " + firstHeroName
                        + " and Hero " + secondHeroName + " of " + secondHeroName
        );
        System.out.println("The battle begin!");
    }

    private static BattleResult executeBattle(@NonNull Hero firstHero, @NonNull Hero secondHero) {
        int firstHeroExp = 0;
        int secondHeroExp = 0;
        boolean turn = true;
        boolean prevTurnResult = true;
        boolean drawFlag = false;
        while(!firstHero.getCreatures().isEmpty() && !secondHero.getCreatures().isEmpty()) {
            if (drawFlag) {
                break;
            }
            boolean currentTurnResult;
            int exp;
            if (turn) {
                exp = doTurn(firstHero, secondHero);
                firstHeroExp += exp;
                turn = false;
            } else {
                exp = doTurn(secondHero, firstHero);
                secondHeroExp += exp;
                turn = true;
            }
            currentTurnResult = exp > 0;
            if (!prevTurnResult && !currentTurnResult) {
                drawFlag = true;
            } else {
                prevTurnResult = currentTurnResult;
            }
        }

        return new BattleResult(firstHeroExp, secondHeroExp, drawFlag);
    }

    private static void handleResult(@NonNull BattleResult result, @NonNull Hero firstHero, @NonNull Hero secondHero) {
        printResult(result.isDrawFlag(), firstHero, secondHero);
        calcExperience(result.getFirstHeroExp(), firstHero);
        calcExperience(result.getSecondHeroExp(), secondHero);
    }

    private static void calcExperience(int exp, @NonNull Hero hero) {
        if (exp > 0) {
            System.out.println(
                    "\nHero " + hero.getName() + " of " + hero.getFraction()
                            + " earned " + exp + " xp");
            hero.computeLevel(exp);
        }
    }

    private static void printResult(boolean drawFlag, @NonNull Hero firstHero, @NonNull Hero secondHero) {
        if (drawFlag) {
            System.out.println("Two armies are even! Time to retreat and grow powers!");
        } else {
            Hero winner;
            if (firstHero.getCreatures().isEmpty()) {
                winner = secondHero;
            } else {
                winner = firstHero;
            }
            System.out.println("\nThat was a tough battle!");
            System.out.println("The winner is Hero " + winner.getName() + " of " + winner.getFraction());
        }
    }

    @Data
    private static class BattleResult {
        private final int firstHeroExp;
        private final int secondHeroExp;
        private final boolean drawFlag;
    }
}
