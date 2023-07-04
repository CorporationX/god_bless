package faang.school.godbless.SuperheroesBattle;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Battle {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        // Superheroes creation
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 10);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero blackWidow = new Superhero("blackWidow", 4, 4);
        Superhero hawkeye = new Superhero("hawkeye", 3, 3);

        // List of superheroes creation
        List<AbstractMap.SimpleEntry<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new AbstractMap.SimpleEntry<>(ironMan, captainAmerica),
                new AbstractMap.SimpleEntry<>(thor, hulk),
                new AbstractMap.SimpleEntry<>(blackWidow, hawkeye)
        );

        getWinnersFutures(superheroBattle, superheroPairs, 1, new ArrayList<>());
    }

    private static void getWinnersFutures(SuperheroBattle superheroBattle, List<AbstractMap.SimpleEntry<Superhero, Superhero>> superheroPairs, int round, List<Future<Superhero>> initialList) throws ExecutionException, InterruptedException {
        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        for (Future<Superhero> winnersFuture : winnersFutures) {
            try {
                Superhero winner = winnersFuture.get();
                System.out.println("Winner " + (round++) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        if (initialList.size() > 0) {
            winnersFutures.add(initialList.get(0));
        }

        if (winnersFutures.size() > 1) {
            System.out.println("---------------");
            List<AbstractMap.SimpleEntry<Superhero, Superhero>> newPairs = new ArrayList<>();
            List<Future<Superhero>> newList = new ArrayList<>();

            if (winnersFutures.size() % 2 != 0) {
                newList.add(winnersFutures.get(0));
                System.out.println("Auto winner:" + winnersFutures.get(0).get().getName());
                winnersFutures.remove(0);
            }

            for (int i = 0; i < winnersFutures.size(); i += 2) {
                newPairs.add(new AbstractMap.SimpleEntry<>(winnersFutures.get(i).get(), winnersFutures.get(i + 1).get()));
            }

            getWinnersFutures(superheroBattle, newPairs, round, newList);
        }

    }
}
