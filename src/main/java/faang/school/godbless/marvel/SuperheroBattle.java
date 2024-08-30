package faang.school.godbless.marvel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SuperheroBattle {

    private Superhero compete(Superhero first, Superhero second) {
        if (first.getStrength() * 10 + first.getAgility() * 7 > second.getStrength() * 10 + second.getAgility() * 7) {
            return first;
        } else {
            return second;
        }
    }

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairs) {
        List<Future<Superhero>> futureWinners = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(pairs.size());

        for (Pair<Superhero, Superhero> pair : pairs) {
            Future<Superhero> futureSuperhero = executorService.submit(() -> compete(pair.first(), pair.second()));
            futureWinners.add(futureSuperhero);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(3, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        return futureWinners;
    }

    public List<Pair<Superhero, Superhero>> getPairsFromWinners(List<Future<Superhero>> winners) {
        List<Superhero> winnersList = new ArrayList<>(winners.stream().map(superheroFuture -> {
                    try {
                        return superheroFuture.get();
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("Making pairs failed");
                        return null;
                    }
                })
                .toList());
        if (winnersList.size() % 2 != 0) {
            winnersList.remove(winnersList.size() - 1);
        }
        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();
        for (int i = 0; i < winnersList.size() - 1; i++) {
            pairs.add(new Pair<>(winnersList.get(i), winnersList.get(i + 1)));
        }
        return pairs;
    }

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero flash = new Superhero("Flash", 2, 10);
        Superhero spiderman = new Superhero("Spiderman", 10, 6);
        Superhero batman = new Superhero("Batman", 10, 4);
        Superhero wonderWoman = new Superhero("Wonder Woman", 3, 8);

        List<Pair<Superhero, Superhero>> superheroPairs = List.of(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(flash, batman),
                new Pair<>(spiderman, wonderWoman)
        );

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        while (winnersFutures.size() > 1) {
            winnersFutures = superheroBattle.runCompetitions(superheroBattle.getPairsFromWinners(winnersFutures));
        }

        try {
            Superhero winner = winnersFutures.get(0).get();
            System.out.println("The winner is " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Battle was interrupted");
        }
    }
}
