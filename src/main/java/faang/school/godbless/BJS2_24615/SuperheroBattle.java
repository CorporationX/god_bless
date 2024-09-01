package faang.school.godbless.BJS2_24615;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SuperheroBattle {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> heroPairs) {
        return heroPairs.stream()
                .map(pair -> executor.submit(() -> getWinnerSuperhero(pair)))
                .toList();
    }

    private Superhero getWinnerSuperhero(Pair<Superhero, Superhero> pair) {
        if (pair.getValue() == null) {
            return pair.getKey();
        }
        return pair.getKey().getTotalPower() > pair.getValue().getTotalPower() ? pair.getKey() : pair.getValue();
    }

    public Future<Superhero> getStrongestSuperhero(List<Pair<Superhero, Superhero>> heroPairs) {

        List<Future<Superhero>> futures = runCompetitions(heroPairs);

        while (futures.size() > 1) {

            List<Superhero> winners = new ArrayList<>();

            futures.forEach(future -> {
                try {
                    Superhero hero = future.get();
                    winners.add(hero);
                    System.out.println("Победитель раунда" + ": " + hero.getName());
                } catch (InterruptedException | ExecutionException e) {
                    log.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            });
            futures = runCompetitions(splitIntoPairs(winners));
        }
        return futures.get(0);
    }

    private List<Pair<Superhero, Superhero>> splitIntoPairs(List<Superhero> heroPairs) {

        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();

        for (int i = 0; i < heroPairs.size() - 1; i += 2) {
            pairs.add(new Pair<>(heroPairs.get(i), heroPairs.get(i + 1)));
        }

        if (heroPairs.size() % 2 != 0) {
            pairs.add(new Pair<>(heroPairs.get(heroPairs.size() - 1), null));
        }

        return pairs;
    }

    public void shutdown() {
        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All threads terminated");
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
