package faang.school.godbless.Sprint_5.Multithreading_Async.SuperheroesBattle;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Competition {
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

        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                Superhero winner = winnersFutures.get(i).get();
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
