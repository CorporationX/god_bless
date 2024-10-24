package school.faang.BJS2_38415_SuperheroesBattle;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class SuperheroBattle {
    private static final int THREAD_POOL_SIZE = 3;

    private ExecutorService executor;

    public SuperheroBattle() {
        executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        return pairs.stream()
                .map(pair -> executor.submit(() -> startBattle(pair)))
                .toList();
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }

    private Superhero startBattle(Pair<Superhero, Superhero> pair) {
        Superhero first = pair.getLeft();
        int firstStats = first.getAgility() + first.getPower();
        Superhero second = pair.getRight();
        int secondStats = second.getAgility() + second.getPower();

        if (firstStats > secondStats) {
            return first;
        } else if (secondStats > firstStats) {
            return second;
        } else {
            return ThreadLocalRandom.current().nextBoolean() ? first : second;
        }
    }
}
