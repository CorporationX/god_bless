package school.faang.superheroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
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

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        while (winnersFutures.size() > 1) {
            superheroPairs = new ArrayList<>();
            for (int i = 0; i < winnersFutures.size(); i += 2) {
                try {
                    Superhero winner = winnersFutures.get(i).get();
                    Superhero winner2 = winnersFutures.get(i + 1).get();
                    superheroPairs.add(new Pair<>(winner, winner2));
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            winnersFutures = superheroBattle.runCompetitions(superheroPairs);
        }

        try {
            Superhero winner = winnersFutures.get(0).get();
            System.out.println("Победитель финального боя: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        superheroBattle.shutdown();
    }
}