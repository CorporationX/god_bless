package school.faang.multithreading.asynchronism.superheroes.bettle;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SuperheroBattle {
    private static final int THREADS_COUNT = 5;

    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
    private final Random random = new Random();

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairsSuperhero) {
        return pairsSuperhero.stream()
                .map(pair -> executor.submit(() -> {
                    Superhero superhero1 = pair.getLeft();
                    Superhero superhero2 = pair.getRight();
                    Superhero winner = battle(superhero1, superhero2);
                    return winner;
                }))
                .collect(Collectors.toList());
    }

    private Superhero battle(Superhero superhero1, Superhero superhero2) {
        int power1 = calculatePower(superhero1);
        int power2 = calculatePower(superhero2);

        return power1 == power2
                ? chooseRandomWinner(superhero1, superhero2)
                : (power1 > power2 ? superhero1 : superhero2);
    }

    private int calculatePower(Superhero superhero) {
        return superhero.getStrength() * superhero.getAgility();
    }

    private Superhero chooseRandomWinner(Superhero superhero1, Superhero superhero2) {
        return random.nextBoolean() ? superhero1 : superhero2;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
