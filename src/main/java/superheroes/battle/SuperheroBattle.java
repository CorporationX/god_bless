package superheroes.battle;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SuperheroBattle {
    private static final int POOL_SIZE = 64;
    private final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public List<Future<Superhero>> runCompetition(@NonNull List<Pair<Superhero, Superhero>> heroesPairs) {
        return heroesPairs.stream()
                .map(p -> executor.submit(() -> battle(p)))
                .toList();
    }

    private Superhero battle(@NonNull Pair<Superhero, Superhero> heroesPair) {
        log.info(String.format("Battle between %s and %s begin!",
                heroesPair.getFirst().getName(), heroesPair.getSecond().getName()));
        int firstPower = heroesPair.getFirst().getStrength() + heroesPair.getFirst().getAgility();
        int secondPower = heroesPair.getSecond().getStrength() + heroesPair.getSecond().getAgility();
        if (firstPower > secondPower) {
            return heroesPair.getFirst();
        }
        if (secondPower > firstPower) {
            return heroesPair.getSecond();
        }
        if (ThreadLocalRandom.current().nextInt(100) > 49) {
            return heroesPair.getSecond();
        } else {
            return heroesPair.getFirst();
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}
