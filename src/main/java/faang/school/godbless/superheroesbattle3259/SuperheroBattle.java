package faang.school.godbless.superheroesbattle3259;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SuperheroBattle {
    static final Superhero IRON_MAN = new Superhero("Iron Man", 9, 6);
    static final Superhero CAPTAIN_AMERICA = new Superhero("Captain America", 8, 8);
    static final Superhero THOR = new Superhero("Thor", 10, 7);
    static final Superhero HULK = new Superhero("Hulk", 10, 4);
    static final Superhero SPIDER_MAN = new Superhero("Spider-Man", 8, 10);
    static final Superhero BLACK_WIDOW = new Superhero("Black widow", 6, 8);
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);
    static List<Superhero> superheroesAlive = new ArrayList<>(List.of(
            IRON_MAN, CAPTAIN_AMERICA, THOR, HULK, SPIDER_MAN, BLACK_WIDOW
    ));
    static final Object SUPERHEROES_ALIVE_LOCK = new Object();

    public static void main(String[] args) {
        while (superheroesAlive.size() > 1) {
            List<Pair<Superhero, Superhero>> listOfPairs = new ArrayList<>();
            for (int i = 0; i <= superheroesAlive.size() - 2; i += 2) {
                listOfPairs.add(new Pair<>(superheroesAlive.get(i), superheroesAlive.get(i + 1)));
            }
            runCompetitions(listOfPairs);
        }
        executorShutdownAndAwait();
        System.out.println("And the winner of the whole thing is: " + superheroesAlive.get(0).getName());
    }


    public static List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroPairs) {
        return superheroPairs.stream()
                .map(pair -> EXECUTOR.submit(() -> {
                    while (true) { // на всякий случай, если вдруг их totalPower окажутся одинаковыми
                        if (pair.getFirst().getTotalPower() > pair.getSecond().getTotalPower()) {
                            synchronized (SUPERHEROES_ALIVE_LOCK) {
                                superheroesAlive.remove(pair.getSecond());
                                return pair.getFirst();
                            }
                        }
                        if (pair.getFirst().getTotalPower() < pair.getSecond().getTotalPower()) {
                            synchronized (SUPERHEROES_ALIVE_LOCK) {
                                superheroesAlive.remove(pair.getFirst());
                                return pair.getSecond();
                            }
                        }
                        pair.getFirst().setStrength(pair.getFirst().getStrength() + 1); // читерим
                    }
                }))
                .toList();
    }

    private static void executorShutdownAndAwait() {
        EXECUTOR.shutdown();
        try {
            EXECUTOR.awaitTermination(15L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
