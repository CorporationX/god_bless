package faang.school.godbless.superheroesbattle3259;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    static final Superhero IRON_MAN = new Superhero("Iron Man", 9, 6);
    static final Superhero CAPTAIN_AMERICA = new Superhero("Captain America", 8, 8);
    static final Superhero THOR = new Superhero("Thor", 10, 7);
    static final Superhero HULK = new Superhero("Hulk", 10, 4);
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        List<Pair<Superhero, Superhero>> listOfPairs = new ArrayList<>(Arrays.asList(
                new Pair<>(IRON_MAN, CAPTAIN_AMERICA),
                new Pair<>(THOR, HULK)
        ));
        System.out.println("Here are winners of first Round: ");
        runCompetitions(listOfPairs).forEach(future -> {
                    try {
                        System.out.println(future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });
        EXECUTOR.shutdown();
    }

    public static List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroPairs) {
        return superheroPairs.stream()
                .map(pair -> EXECUTOR.submit(() -> {
                    while (true) {
                        if (pair.getFirst().getTotalPower() > pair.getSecond().getTotalPower()) {
                            return pair.getFirst();
                        }
                        if (pair.getFirst().getTotalPower() < pair.getSecond().getTotalPower()) {
                            return pair.getSecond();
                        }
                        pair.getFirst().setStrength(pair.getFirst().getStrength() + 1);
                    }
                }))
                .toList();
    }
}
