package faang.school.godbless.BJS2_24690;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        SuperheroBattle superheroBattle = new SuperheroBattle(executor);

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<Pair> superheroPairs = Arrays.asList(
                new Pair(ironMan, captainAmerica),
                new Pair(thor, hulk)
        );

        while (superheroPairs.size() > 1) {
            System.out.println("START!");
            var futures = superheroBattle.runCompetitions(superheroPairs);

            List<Superhero> superheroes = futures.stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }).toList();

            superheroPairs = getPairs(superheroes);
            System.out.println("END!");
        }

        Pair lastPair = superheroPairs.get(0);
        Superhero winner = superheroBattle.battle(lastPair);
        System.out.println("Winner: " + winner.getName());

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Pair> getPairs(List<Superhero> superheroes) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < superheroes.size() - 1; i+=2) {
            pairs.add(new Pair(superheroes.get(i), superheroes.get(i + 1)));
        }
        return pairs;
    }
}
