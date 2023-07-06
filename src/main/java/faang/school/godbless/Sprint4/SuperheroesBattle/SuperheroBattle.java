package faang.school.godbless.Sprint4.SuperheroesBattle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public Superhero runCompetitions(Superhero hero1, Superhero hero2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("fight is started " + hero1.getName() + " vs " + hero2.getName());
        Future<Superhero> fighter1 = executor.submit(() -> bit(hero1, hero2));
        Future<Superhero> fighter2 = executor.submit(() -> bit(hero2, hero1));

        while (!fighter1.isDone() && !fighter2.isDone()) {
        }

        executor.shutdown();

        if (fighter1.isDone()) {
            fighter2.cancel(fighter1.isDone());
            logFinish(hero1, hero2);
            return hero2;
        } else {
            fighter1.cancel(fighter2.isDone());
            logFinish(hero2, hero1);
            return hero1;
        }
    }

    private void logFinish(Superhero winner, Superhero loser) {
        System.out.println("winner is " + winner.getName());
        winner.setHealth(winner.getFullHp());
        System.out.println(loser.getName() + " loss...");
    }

    private Superhero bit(Superhero attacker, Superhero defender) throws InterruptedException {
        while (defender.getHealth() > 0) {
            defender.setHealth(defender.getHealth() - attacker.getAgility() - attacker.getStrength());
            System.out.println("HP " + defender.getName() + " is " + defender.getHealth());
            Thread.sleep((long) (Math.random() * 1000));
        }
        return attacker;
    }
}
