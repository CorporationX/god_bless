package faang.school.godbless.BJS2_4275;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battlefield {
    public static void simulation() {

        Hero tony = new Hero("Tony", addFractions());
        Hero bob = new Hero("Bob", addFractions());

        int round = 0;

        while (!tony.isLoss() && !bob.isLoss()) {
            System.out.printf("Start: %d round", round);
            if (round % 2 == 0) {
                attack(tony, bob);
            } else {
                attack(bob, tony);
            }
            round++;
        }
        System.out.println("Game over");
    }

    private static void attack(Hero attackHero, Hero defenderHero) {
        Creature fractionAttack = randomFraction(attackHero);
        Creature fractionDefense = randomFraction(defenderHero);
        attackHero.attack(defenderHero, fractionDefense, fractionAttack);
    }

    private static Creature randomFraction(Hero hero) {
        Random random = new Random();
        List<Creature> fractions = hero.getFractions();
        int countFractions = fractions.size();
        if (countFractions == 1) {
            return fractions.get(0);
        } else if (countFractions > 1) {
            int indexFractions = random.nextInt(countFractions);
            return fractions.get(indexFractions);
        }
        return new Pikeman();
    }

    private static List<Creature> addFractions() {
        Random random = new Random();
        List<Creature> fractions = new ArrayList<>();
        while (fractions.size() <= 9) {
            switch (random.nextInt(9)) {
                case 1, 5 -> fractions.add(new Pikeman());
                case 2, 6 -> fractions.add(new Griffin());
                case 3, 7 -> fractions.add(new Angel());
                case 4, 8 -> fractions.add(new Swordman());
            }
        }
        return fractions;
    }
}
