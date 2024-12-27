package school.faang.sprint_4.task_50584;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SuperheroBattle {
    private static final int NUMBER_OF_THREADS = 4;
    private static final int AWAIT_TIME = 1;
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroesPairs) {
        validateSuperheroList(superheroesPairs);

        List<Future<Superhero>> futures = new ArrayList<>();
        for (Pair<Superhero, Superhero> superheroPair : superheroesPairs) {
            futures.add(executorService.submit(() -> {
                Superhero first = superheroPair.first();
                Superhero second = superheroPair.second();
                return compete(first, second);
            }));
        }

        return futures;
    }

    private void validateSuperheroList(List<Pair<Superhero, Superhero>> superheroesPairs) {
        int size = superheroesPairs.size();
        if (size > 0) {
            double  binaryLogarithm = Math.log(size) / Math.log(2);
            if (binaryLogarithm == (int) binaryLogarithm) {
                return;
            }
        }

        throw new IllegalArgumentException("The number of superheroes must "
                + "be part of the geometric progression  2, 4, 8, 16, 32, ...");
    }

    private Superhero compete(Superhero first, Superhero second) {
        int firstPower = first.getPower();
        int secondPower = second.getPower();

        if (firstPower > secondPower) {
            return first;
        } else if (firstPower < secondPower) {
            return second;
        } else {
            return Math.random() < 0.5 ? first : second;
        }
    }

    public void shutdown() {
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.info("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Thread {} was interrupted. Shutting down...", Thread.currentThread().getName());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("Shut down completed.");
    }
}
