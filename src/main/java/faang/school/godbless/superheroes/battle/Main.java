package faang.school.godbless.superheroes.battle;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 11, 4);

        List<MyPair<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new MyPair<>(ironMan, captainAmerica),
                new MyPair<>(thor, hulk)
        );

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);
        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                Superhero winner = winnersFutures.get(i).get();
                System.out.println("The winner " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

