package faang.school.godbless.Sprint4Future.SuperheroBattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SuperheroBattle {
    private List<Future<Superhero>> winners = new ArrayList<>();

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<Pair<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk)
        );

        superheroBattle.runCompetitions(superheroPairs);

        for (int i = 0; i < superheroBattle.winners.size(); i++) {
            try {
                Superhero winner = superheroBattle.winners.get(i).get();
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("Победил всех: " + superheroBattle.winners.get(superheroBattle.winners.size() - 1).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void runCompetitions(List<Pair<Superhero, Superhero>> superheroPairs) {
        ExecutorService executorService = Executors.newFixedThreadPool(superheroPairs.size());
        for (Pair<Superhero, Superhero> superheroPair : superheroPairs) {
            Future<Superhero> winner = executorService.submit(() -> {
                if (superheroPair.first.getPointsToWin() > superheroPair.second.getPointsToWin()) {
                    return superheroPair.first;
                } else {
                    return superheroPair.second;
                }
            });
            winners.add(winner);
        }
        if (superheroPairs.size() > 1) {
            runCompetitions(getNewPairs(winners));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //return winners;
    }

    private List<Pair<Superhero, Superhero>> getNewPairs(List<Future<Superhero>> winners) {
        List<Pair<Superhero, Superhero>> superheroPairs = new ArrayList<>();
        for (int i = 0; i < winners.size(); i = i + 2) {
            try {
                superheroPairs.add(new Pair<>(winners.get(i).get(), winners.get(i + 1).get()));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return superheroPairs;
    }
}
