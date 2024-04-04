package faang.school.godbless.BJS2_4275.main;

import faang.school.godbless.BJS2_4275.heroes_models.Angel;
import faang.school.godbless.BJS2_4275.heroes_models.Creature;
import faang.school.godbless.BJS2_4275.heroes_models.Griffin;
import faang.school.godbless.BJS2_4275.heroes_models.Hero;
import faang.school.godbless.BJS2_4275.heroes_models.Pikeman;
import faang.school.godbless.BJS2_4275.heroes_models.Swordman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battlefield {
    public static void main(String[] args) {

        Hero tony = new Hero("Tony", 0, 0, addFractions(), false);
        Hero bob = new Hero("Bob", 0, 0, addFractions(), false);

        int round = 0;

        while (!tony.isLoss() || !bob.isLoss()) {
            if (round % 2 == 0) {
                Creature fractionAttack = randomFraction(tony);
                Creature fractionDefense = randomFraction(bob);
                tony.attack(bob, fractionDefense, fractionAttack.getPower());
            } else {
                Creature fractionDefense = randomFraction(tony);
                Creature fractionAttack = randomFraction(bob);
                bob.attack(tony, fractionDefense, fractionAttack.getPower());
            }
            round++;
        }

        System.out.println("Tony Hero : " + tony.isLoss());
        System.out.println("Bob Hero : " + bob.isLoss());

    }

    private static Creature randomFraction(Hero hero) {
        Random random = new Random();
        List<Creature> fractions = hero.getFractions();
        if (fractions.size() == 1) {
            return fractions.get(0);
        } else {
            int indexFractions = random.nextInt(fractions.size());
            return fractions.get(indexFractions);
        }
    }

    private static List<Creature> addFractions() {
        Random random = new Random();
        List<Creature> fractions = new ArrayList<>();
        while (fractions.size() <= 9) {
            switch (random.nextInt(9)) {
                case 1:
                case 5:
                    fractions.add(new Pikeman());
                    break;
                case 2:
                case 6:
                    fractions.add(new Griffin());
                    break;
                case 3:
                case 7:
                    fractions.add(new Angel());
                    break;
                case 4:
                case 8:
                    fractions.add(new Swordman());
                    break;
            }
        }
        return fractions;
    }

}
