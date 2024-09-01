package faang.school.godbless.BJS2_24615;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        List<Pair<Superhero, Superhero>> superheroPairs = getPairs();

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                Superhero winner = winnersFutures.get(i).get();
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }

        Future<Superhero> winnerFuture = superheroBattle.getStrongestSuperhero(superheroPairs);

        try {
            Superhero absoluteWinner = winnerFuture.get();
            System.out.println("Strongest Superhero: " + absoluteWinner.getName());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }


        superheroBattle.shutdown();
    }

    private static List<Pair<Superhero, Superhero>> getPairs() {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero antMan = new Superhero("Ant Man", 8, 5);
        Superhero deadPool = new Superhero("DeadPool", 10, 6);
        Superhero spiderMan = new Superhero("SpiderMan", 9, 7);
        Superhero captainMarvel = new Superhero("Captain Marvel", 10, 9);

        return Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(antMan, deadPool),
                new Pair<>(spiderMan, captainMarvel)
        );
    }
}
