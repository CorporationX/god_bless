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
                .map(pair -> executor.submit(() -> pair.getKey().getTotalPower() > pair.getValue().getTotalPower() ? pair.getKey() : pair.getValue()))
                .toList();
    }

    public Future<Superhero> getStrongestSuperhero(List<Pair<Superhero, Superhero>> heroPairs) {

        List<Future<Superhero>> futures = runCompetitions(heroPairs);

        System.out.println(futures.size());

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

        if (futures.size() == 1) {

            return futures.get(0);
        } else {
            return getStrongestSuperhero(splitIntoPairs(winners));
        }
    }

    private List<Pair<Superhero, Superhero>> splitIntoPairs(List<Superhero> heroPairs) {
        int left = 0;
        int right = heroPairs.size() - 1;

        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();

        while (right - left >= 0) {
            pairs.add(new Pair<>(heroPairs.get(left), heroPairs.get(right)));
            left++;
            right--;
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
