package school.faang.superheroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private ExecutorService executor = Executors.newFixedThreadPool(8);

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        List<Future<Superhero>> winners = new ArrayList<>();
        for (Pair<Superhero, Superhero> pair : pairs) {
            winners.add(executor.submit(() -> {
                int powerAttackFirst = pair.getL().getAgility() + pair.getL().getStrength();
                int powerAttackSecond = pair.getR().getAgility() + pair.getR().getStrength();
                return powerAttackFirst > powerAttackSecond ? pair.getL() : pair.getR();
            }));
        }
        return winners;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
