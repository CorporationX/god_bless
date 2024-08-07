package homm;

import homm.creatures.Creature;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battlefield {
    public static void battle(@NonNull Hero firstHero, @NonNull Hero secondHero) {
        System.out.println(
                "\nThe battle between Hero " + firstHero.getName() + " of " + firstHero.getFraction()
                + " and Hero " + secondHero.getName() + " of " + secondHero.getFraction()
        );
        System.out.println("The battle begin!");
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
            if (turn) {
                int exp = doTurn(firstHero, secondHero);
                currentTurnResult = exp > 0;
                firstHeroExp += exp;
                turn = false;
            } else {
                int exp = doTurn(secondHero, firstHero);
                currentTurnResult = exp > 0;
                secondHeroExp += exp;
                turn = true;
            }
            if (!prevTurnResult && !currentTurnResult) {
                drawFlag = true;
            } else {
                prevTurnResult = currentTurnResult;
            }
        }
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
        if (firstHeroExp > 0) {
            System.out.println(
                    "\nHero " + firstHero.getName() + " of " + firstHero.getFraction()
                    + " earned " + firstHeroExp + " xp"
            );
            firstHero.computeLevel(firstHeroExp);
        }
        if (secondHeroExp > 0) {
            System.out.println(
                    "\nHero " + secondHero.getName() + " of " + secondHero.getFraction()
                            + " earned " + secondHeroExp + " xp"
            );
            secondHero.computeLevel(secondHeroExp);
        }
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

    private static int doTurn(Hero attacker, @NonNull Hero defender) {
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
}
