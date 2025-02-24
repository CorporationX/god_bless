package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final int THREAD_POOL_SIZE = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Pair<Superhero, Superhero>> heroes = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            Superhero hero1 = new Superhero("hero " + i, random.nextInt(30), random.nextInt(30));
            Superhero hero2 = new Superhero("hero " + i * 2, random.nextInt(30), random.nextInt(30));
            heroes.add(new Pair<>(hero1, hero2));
        }
        SuperheroBattle battle = new SuperheroBattle();
        List<Future<Superhero>> futures = battle.runCompetitions(heroes, executor);

        for (Future<Superhero> future : futures) {
            try {
                System.out.printf("Winner of competition: %s\n", future.get().getName());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
    }
}
