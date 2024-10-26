package school.faangSprint4.t10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SuperheroBattle {
    private final ExecutorService executor;
    private final Random random = new Random();

    public SuperheroBattle() {
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroPairs) {
        return superheroPairs.stream()
                .map(pair -> executor.submit(() -> compete(pair.getFirst(), pair.getSecond())))
                .collect(Collectors.toList());
    }

    private Superhero compete(Superhero hero1, Superhero hero2) {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int power1 = hero1.getPower();
        int power2 = hero2.getPower();

        if (power1 != power2) {
            return power1 > power2 ? hero1 : hero2;
        }
        if (hero1.agility() != hero2.agility()) {
            return hero1.agility() > hero2.agility() ? hero1 : hero2;
        }
        return random.nextBoolean() ? hero1 : hero2;
    }

    public Superhero findUltimateWinner(List<Superhero> heroes) throws InterruptedException, ExecutionException {
        if (heroes.size() <= 1) {
            return heroes.isEmpty() ? null : heroes.get(0);
        }

        while (heroes.size() > 1) {
            System.out.println("\nNew round starting with " + heroes.size() + " heroes!");
            List<Pair<Superhero, Superhero>> pairs = createRandomPairs(heroes);
            List<Future<Superhero>> winnersFutures = runCompetitions(pairs);

            heroes = new ArrayList<>();
            for (Future<Superhero> future : winnersFutures) {
                heroes.add(future.get());
            }

            if (pairs.size() * 2 < heroes.size()) {
                heroes.add(heroes.get(heroes.size() - 1));
            }
        }

        return heroes.get(0);
    }

    private List<Pair<Superhero, Superhero>> createRandomPairs(List<Superhero> heroes) {
        List<Superhero> shuffled = new ArrayList<>(heroes);
        Collections.shuffle(shuffled);
        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();

        for (int i = 0; i < shuffled.size() - 1; i += 2) {
            pairs.add(new Pair<>(shuffled.get(i), shuffled.get(i + 1)));
        }

        return pairs;
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}