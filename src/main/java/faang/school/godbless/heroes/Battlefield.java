package faang.school.godbless.heroes;

import faang.school.godbless.heroes.creatures.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;
    private List<Creature> firstHeroArmy;
    private List<Creature> secondHeroArmy;
    private boolean isWinner;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
        this.firstHeroArmy = firstHero.getArmy();
        this.secondHeroArmy = secondHero.getArmy();
        this.isWinner = false;
    }

    public Hero battle() {
        while (!isWinner) {
            makeTurn(new ArrayList<>(firstHeroArmy), new ArrayList<>(secondHeroArmy));
        }
        if (firstHeroArmy.isEmpty()) {
            return secondHero;
        } else {
            return firstHero;
        }
    }

    private void makeTurn(List<Creature> firstArmy, List<Creature> secondArmy) {
        if (firstHeroArmy.isEmpty() || secondHeroArmy.isEmpty()) {
            isWinner = true;
            return;
        }
        if (firstArmy.size() == 0 && secondArmy.size() == 0) {
            return;
        }
        Creature attacker = getFastestCreature(firstArmy, secondArmy);
        Creature defender;
        boolean isFirstArmyAttacking = firstArmy.contains(attacker);
        if (isFirstArmyAttacking) {
            firstArmy.remove(attacker);
            int getInt = 0;
            if (secondHeroArmy.size() > 0) {
                getInt = new Random().nextInt(secondHeroArmy.size());
            }
            defender = secondHeroArmy.get(getInt);
        } else {
            secondArmy.remove(attacker);
            int getInt = 0;
            if (firstHeroArmy.size() > 0) {
                new Random().nextInt(firstHeroArmy.size());
            }
            defender = firstHeroArmy.get(getInt);
        }
        attack(attacker, defender);
        if (defender.getQuantity() == 0) {
            if (isFirstArmyAttacking) {
                secondHeroArmy.remove(defender);
            } else {
                firstHeroArmy.remove(defender);
            }
        }
            makeTurn(firstArmy, secondArmy);
    }

    private void attack(Creature attacker, Creature defender) {
        int attack = attacker.getDamage() * attacker.getQuantity();
        int defence = defender.getDefence() * defender.getQuantity();
        int left = (defence - attack) / defender.getDefence();
        left = left < 0 ? 0 : left;
        System.out.printf("%s attacks %s for %d damage, there is %d %s left", attacker.getName(), defender.getName(), attack, left, defender.getName());
        System.out.println();
        defender.setQuantity(left);
    }

    private Creature getFastestCreature(List<Creature> firstArmy, List<Creature> secondArmy) {
        if (firstArmy.isEmpty()) {
            return secondArmy.get(0);
        }
        if (secondArmy.isEmpty()) {
            return firstArmy.get(0);
        }
        Creature firstArmyFastest = firstArmy.get(0);
        for (Creature creature : firstArmy) {
            if (creature.getSpeed() > firstArmyFastest.getSpeed()) {
                firstArmyFastest = creature;
            }
        }
        Creature secondArmyFastest = secondArmy.get(0);
        for (Creature creature : secondArmy) {
            if (creature.getSpeed() > secondArmyFastest.getSpeed()) {
                secondArmyFastest = creature;
            }
        }

        return firstArmyFastest.getSpeed() > secondArmyFastest.getSpeed() ? firstArmyFastest : secondArmyFastest;
    }
}
