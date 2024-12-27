package school.faang.sprint_4.task_50584;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        List<Pair<Superhero, Superhero>> superheroPairs = getSuperheroPairs();

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        while (winnersFutures.size() > 1) {
            List<Superhero> previousStageWinners = getWinnersFromFuturesAndPrint(winnersFutures);
            List<Pair<Superhero, Superhero>> pairsToNextStep = generatePairsToNextStep(previousStageWinners);
            winnersFutures = superheroBattle.runCompetitions(pairsToNextStep);
        }

        try {
            System.out.println("And final WINNER!!! " + winnersFutures.get(0).get());
        } catch (InterruptedException | ExecutionException e) {
            log.info("Some problem with final winner");
        }
        superheroBattle.shutdown();
    }

    private static List<Pair<Superhero, Superhero>> generatePairsToNextStep(List<Superhero> previousStageWinners) {
        List<Pair<Superhero, Superhero>> pairs = new ArrayList<>();
        for (int i = 0; i < previousStageWinners.size() - 1; i += 2) {
            pairs.add(new Pair<>(previousStageWinners.get(i), previousStageWinners.get(i + 1)));
        }
        return pairs;
    }

    private static List<Superhero> getWinnersFromFuturesAndPrint(List<Future<Superhero>> winnersFutures) {
        List<Superhero> winners = new ArrayList<>();
        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                Superhero winner = winnersFutures.get(i).get();
                winners.add(winner);
                System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.name());
            } catch (InterruptedException | ExecutionException e) {
                log.info("Соревнование {} прервано. {}",
                        i + 1,
                        Arrays.toString(e.getStackTrace()));
            }
        }
        return winners;
    }

    private static List<Pair<Superhero, Superhero>> getSuperheroPairs() {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        return Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk)
        );
    }
}
