package school.faang.superherobattle;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Battle {

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero spiderMan = new Superhero("Spider Man", 6, 10);
        Superhero spongeBob = new Superhero("Sponge Bob", 10, 9);
        Superhero loki = new Superhero("Loki", 4, 11);
        Superhero gambit = new Superhero("Gambit", 6, 7);

        List<Pair<Superhero, Superhero>> superheroPairs = Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(spiderMan, spongeBob),
                new Pair<>(loki, gambit)
        );

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);
        List<Superhero> roundOneWinners = superheroBattle.getWinners(winnersFutures);

        List<Pair<Superhero, Superhero>> roundTwoPairs = superheroBattle.createPairs(roundOneWinners);
        List<Future<Superhero>> roundTwoWinnersFutures = superheroBattle.runCompetitions(roundTwoPairs);
        List<Superhero> roundTwoWinners = superheroBattle.getWinners(roundTwoWinnersFutures);

        if (roundTwoWinners.size() == 2) {
            List<Pair<Superhero, Superhero>> finalPair = Arrays.asList(
                    new Pair<>(roundTwoWinners.get(0), roundTwoWinners.get(1)));
            List<Future<Superhero>> finalWinnerFuture = superheroBattle.runCompetitions(finalPair);

            try {
                Superhero finalWinner = finalWinnerFuture.get(0).get();
                log.info("Победитель финального соревнования: " + finalWinner.name());
            } catch (InterruptedException | ExecutionException e) {
                log.error("Произошла ошибка при проведении финального соревнования", e);
                Thread.currentThread().interrupt();
            }
        } else {
            log.warn("Не удалось определить двух победителей для финального соревнования.");
        }

        superheroBattle.shutdown();
    }
}
