package faang.school.godbless.bjs2_6012;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SuperheroBattle {

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        List<Pair<Superhero, Superhero>> superheroPairs = getPairs();

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        while (!superheroBattle.areJobsDone(winnersFutures)) {}

        for (int i = 0; i < winnersFutures.size(); i++) {
            try {
                if (winnersFutures.get(i).isDone()) {
                    Superhero winner = winnersFutures.get(i).get();
                    System.out.println("Победитель соревнования " + (i + 1) + ": " + winner.getName());
                }
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage());
            }
        }
        executor.shutdown();
    }

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairList) {
        return pairList.stream()
                .map(pair -> executor.submit(() -> {
                    try {
                        Superhero winner = pair.getLeft();
                        Superhero second = pair.getRight();
                        TimeUnit.SECONDS.sleep(2);
                        if ((winner.getStrength() + winner.getAgility()) < (second.getStrength() + second.getAgility())) {
                            winner = second;
                        }
                        return winner;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })).toList();
    }

    private static List<Pair<Superhero, Superhero>> getPairs() {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);
        Superhero tanos = new Superhero("Tanos", 20, 7);
        Superhero starLord = new Superhero("Star Lord", 7, 21);

        return Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(tanos, starLord)
        );
    }

    private boolean areJobsDone(List<Future<Superhero>> futures) {
        return futures.stream()
                .allMatch(Future::isDone);
    }
}
