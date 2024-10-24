package school.faang.BJS2_38415_SuperheroesBattle;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class BattleField {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        List<Pair<Superhero, Superhero>> superheroPairs = new ArrayList<>();
        superheroPairs.add(Pair.of(ironMan, captainAmerica));
        superheroPairs.add(Pair.of(thor, hulk));

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        while (winnersFutures.size() != 1) {
            List<Superhero> winners = new ArrayList<>(
                    winnersFutures.stream()
                    .map(BattleField::getFutureResult)
                    .toList()
            );
            superheroPairs.clear();
            Collections.shuffle(winners);
            for (int i = 0; i < winners.size(); i += 2) {
                superheroPairs.add(Pair.of(winners.get(i), winners.get(i + 1)));
            }
            winnersFutures = superheroBattle.runCompetitions(superheroPairs);
        }

        log.info("Champion of champions is {}", getFutureResult(winnersFutures.get(0)).getName());
        superheroBattle.shutdownExecutor();
    }

    private static Superhero getFutureResult(Future<Superhero> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception occurred while getting the winner of the battle!", e);
            return null;
        }
    }
}
