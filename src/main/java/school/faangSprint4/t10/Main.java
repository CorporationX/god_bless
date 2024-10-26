package school.faangSprint4.t10;

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
        Superhero blackWidow = new Superhero("Black Widow", 7, 9);
        Superhero spiderMan = new Superhero("Spider-Man", 8, 10);

        List<Pair<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(blackWidow, spiderMan)
        );

        try {
            System.out.println("Running initial competitions...");
            List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

            List<Superhero> winners = new ArrayList<>();
            for (int i = 0; i < winnersFutures.size(); i++) {
                Superhero winner = winnersFutures.get(i).get();
                System.out.println("Winner of battle " + (i + 1) + ": " + winner);
                winners.add(winner);
            }

            System.out.println("\nFinding ultimate winner...");
            Superhero ultimateWinner = superheroBattle.findUltimateWinner(winners);
            System.out.println("\nUltimate winner is: " + ultimateWinner);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            superheroBattle.shutdown();
        }
    }
}