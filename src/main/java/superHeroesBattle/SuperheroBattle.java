package superHeroesBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public List<Future<Superhero>> runCompetitions(List<Pair> pairs) {
        List<Future<Superhero>> winners = new ArrayList<>();
        pairs.forEach(pair -> {
            winners.add(SERVICE.submit(() -> {
                if (pair.getSuperhero1().getStrength() + pair.getSuperhero1().getAgility()
                        >= pair.getSuperhero2().getStrength() + pair.getSuperhero2().getAgility()) {
                    return pair.getSuperhero1();
                }
                return pair.getSuperhero2();
            }));
        });
        return winners;
    }

    public void shutdown() {
        SERVICE.shutdown();
    }
}
