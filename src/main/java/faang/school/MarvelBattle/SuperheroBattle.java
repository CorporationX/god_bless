package faang.school.MarvelBattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SuperheroBattle {
    public List<CompletableFuture<Superhero>> runCompetitions(List<Pair<Superhero>> pairs) {
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(pairs.size(), 7));
        var winners = pairs.stream()
                .map(pair -> CompletableFuture.supplyAsync(() -> {
                    if (pair.first().getAgility() + pair.first().getStrength() > pair.second().getAgility() + pair.second().getStrength())
                        return pair.first();
                    else
                        return pair.second();
                }, executor)).toList();
        executor.shutdown();
        if (winners.size() <= 1) {
            return winners;
        }
        return runCompetitions(getNewPairs(winners));
    }

    private List<Pair<Superhero>> getNewPairs(List<CompletableFuture<Superhero>> winners) {
        List<Superhero> heroes = winners.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).toList();
        List<Pair<Superhero>> newPairs = new ArrayList<>();
        for (int i = 0; i < heroes.size() - 1; i += 2) {
            if (heroes.size() != i + 1) {
                newPairs.add(new Pair<>(heroes.get(i), heroes.get(i + 1)));
            } else {
                newPairs.add(new Pair<>(heroes.get(i), new Superhero("Loser", Integer.MIN_VALUE, Integer.MIN_VALUE)));
            }
        }
        return newPairs;
    }

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 99, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 120, 14);

        List<Pair<Superhero>> superheroPairs = Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(thor, ironMan),
                new Pair<>(ironMan, hulk)
        );
        var winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        winnersFutures.forEach(CompletableFuture::join);
        winnersFutures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
