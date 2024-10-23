package school.faang.superheroesbattle;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public List<Future<Superhero>> runCompetitions(List<SuperheroPair> superheroPairs) {
        List<Future<Superhero>> futures = new ArrayList<>();

        for (SuperheroPair pair : superheroPairs) {
            Future<Superhero> future = executorService.submit(() -> {
                Superhero superhero1 = pair.getHero1();
                Superhero superhero2 = pair.getHero2();

                System.out.println(superhero1.getName() + " vs " + superhero2.getName() + " - Battle begins!");

                int score1 = superhero1.getStrength() + superhero1.getAgility();
                int score2 = superhero2.getStrength() + superhero2.getAgility();

                if (score1 > score2) {
                    System.out.println(superhero1.getName() + " wins!");
                    return superhero1;
                } else if (score2 > score1) {
                    System.out.println(superhero2.getName() + " wins!");
                    return superhero2;
                } else {
                    Superhero winner = Math.random() > 0.5 ? superhero1 : superhero2;
                    System.out.println("It's a tie! Random winner: " + winner.getName());
                    return winner;
                }
            });

            futures.add(future);
        }

        return futures;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}