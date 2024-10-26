package school.faang.superheroesbattle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class SuperheroBattle {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public List<Future<Superhero>> runCompetitions(List<Main.Pair<Superhero, Superhero>> pairs) {
        List<Future<Superhero>> futures = new ArrayList<>();

        for (Main.Pair<Superhero, Superhero> pair : pairs) {
            Callable<Superhero> battleTask = () -> determineWinner(pair.getFirst(), pair.getSecond());
            Future<Superhero> result = executorService.submit(battleTask);
            futures.add(result);
        }

        return futures;
    }

    private Superhero determineWinner(Superhero hero1, Superhero hero2) {
        int hero1Score = hero1.getStrength() + hero1.getAgility();
        int hero2Score = hero2.getStrength() + hero2.getAgility();

        if (hero1Score > hero2Score) {
            return hero1;
        } else if (hero2Score > hero1Score) {
            return hero2;
        } else {
            return ThreadLocalRandom.current().nextBoolean() ? hero1 : hero2;
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
