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
    public static void main(String[] args) throws InterruptedException {

        Hero tony = new Hero("Tony",  addFractions());
        Hero bob = new Hero("Bob",  addFractions());

        int round = 0;

        while (!tony.isLoss() && !bob.isLoss()) {
            System.out.println("Start: " + round + " round");
            if (round % 2 == 0) {
                Creature fractionAttack = randomFraction(tony);
                Creature fractionDefense = randomFraction(bob);
                tony.attack(bob, fractionDefense, fractionAttack.getPower());
                Thread.sleep(5000);
            } else {
                Creature fractionDefense = randomFraction(tony);
                Creature fractionAttack = randomFraction(bob);
                bob.attack(tony, fractionDefense, fractionAttack.getPower());
                Thread.sleep(5000);
            }
            round++;
        }
        System.out.println("Game over");
        System.out.println("Tony Hero : " + tony.isLoss());
        System.out.println("Bob Hero : " + bob.isLoss());
    }

    private static Creature randomFraction(Hero hero) {
        Random random = new Random();
        List<Creature> fractions = hero.getFractions();
        if (fractions.size() == 1) {
            return fractions.get(0);
        } else if (fractions.size() > 1) {
            int indexFractions = random.nextInt(fractions.size());
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
