package faang.school.godbless.fourthsprint.superheroes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SuperheroBattle {
    private static final int MAX_NUM_PAIRS = 8;
    private static final int TIME_OUT = 60;
    private static final int MIN_LUCK_FACTOR = 1;
    private static final int MAX_LUCK_FACTOR = 2;

    private final ExecutorService executor = Executors.newFixedThreadPool(MAX_NUM_PAIRS);
    private int roundCount = 1;

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroPairs) {

        System.out.println("\nThe pairs for round " + roundCount + " are:");
        roundCount++;

        List<Future<Superhero>> futures = new ArrayList<>();

        for (Pair<Superhero, Superhero> pair : superheroPairs) {
            futures.add(executor.submit(() -> {
                Superhero superhero1 = pair.getFirst();
                Superhero superhero2 = pair.getSecond();
                Superhero winner = calculateBattleOutcome(superhero1, superhero2);

                System.out.println(superhero1 + " vs " + superhero2 +
                        ": winner is " + winner.toString().toUpperCase());
                return winner;
            }));
        }
        return futures;
    }

    public Superhero findStrongestSuperhero(List<Superhero> superheroes) throws InterruptedException, ExecutionException {
        List<Superhero> mutableSuperheroes = new ArrayList<>(superheroes);
        List<Superhero> remainingHeroes = new ArrayList<>();

        if (mutableSuperheroes.size() == 1) {
            shutdownExecutor();
            return mutableSuperheroes.get(0);
        }
        if (mutableSuperheroes.size() % 2 != 0) {
            Collections.shuffle(mutableSuperheroes);
            remainingHeroes.add(mutableSuperheroes.remove(0));
        }

        List<Pair<Superhero, Superhero>> superheroPairs = generatePairs(mutableSuperheroes);
        List<Future<Superhero>> winnersFutures = runCompetitions(superheroPairs);

        for (Future<Superhero> future : winnersFutures) {
            remainingHeroes.add(future.get());
        }

        if (remainingHeroes.size() != 1) {
            System.out.println("\nThe following superheroes have been promoted to the next round:");
            System.out.println(remainingHeroes);
        }

        return findStrongestSuperhero(remainingHeroes);
    }

    private List<Pair<Superhero, Superhero>> generatePairs(List<Superhero> superheroes) {
        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();
        Collections.shuffle(superheroes);

        for (int i = 0; i < superheroes.size() - 1; i += 2) {
            pairs.add(new Pair<>(superheroes.get(i), superheroes.get(i + 1)));
        }

        return pairs;
    }

    private void shutdownExecutor() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                System.out.println("Executor did not terminate in the specified time.");
                List<Runnable> droppedTasks = executor.shutdownNow();
                System.out.println("Dropped " + droppedTasks.size() + " tasks.");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for termination.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private Superhero calculateBattleOutcome(Superhero hero1, Superhero hero2) {
        Random random = new Random();
        double hero1Score = hero1.getStrength() * hero1.getAgility() *
                (MIN_LUCK_FACTOR + (random.nextDouble() * (MAX_LUCK_FACTOR - MIN_LUCK_FACTOR)));
        double hero2Score = hero2.getStrength() * hero2.getAgility() *
                (MIN_LUCK_FACTOR + (random.nextDouble() * (MAX_LUCK_FACTOR - MIN_LUCK_FACTOR)));

        return hero1Score > hero2Score ? hero1 : hero2;
    }
}
