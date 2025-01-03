package derschrank.sprint04.task10.bjstwo_50592;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SuperheroBattleService {
    public static final Random rnd = new Random();
    public static final int MAX_STRENGTH = 10;
    public static final int MAX_AGILITY = 10;
    private static final Logger log = LoggerFactory.getLogger(SuperheroBattleService.class);

    public static double goodluckPoints(double originalPoints) {
        return rnd.nextDouble(originalPoints + 1) / 3;
    }

    public static void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Superhero> getHeroes(int count) {
        String[] firstNames = {
                "Bruce", "Clark", "Diana", "Tony", "Steve",
                "Natasha", "Peter", "Wanda", "Stephen", "Barry",
                "Hal", "Arthur", "Victor", "Jean", "Logan",
                "Charles", "Ororo", "Hank", "Scott", "Kurt"
        };

        String[] lastNames = {
                "Wayne", "Kent", "Prince", "Stark", "Rogers",
                "Romanoff", "Parker", "Maximoff", "Strange", "Allen",
                "Jordan", "Curry", "Stone", "Grey", "Howlett",
                "Xavier", "Munroe", "McCoy", "Summers", "Wagner"
        };
        List<Superhero> heroes = new ArrayList<>();
        String firstName;
        String lastName;
        for (int i = 0; i < count; i++) {
            lastName = lastNames[i % lastNames.length];
            firstName = firstNames[(i + i / firstNames.length) % firstNames.length];
            heroes.add(
                    new Superhero(lastName + " " + firstName,
                        rnd.nextInt(MAX_STRENGTH),
                        rnd.nextInt(MAX_AGILITY)
                    )
            );
        }
        return heroes;
    }

    public static List<PairToFight<Superhero>> generatePairsToFight(List<Superhero> heroes) {
        List<PairToFight<Superhero>> pairs = new ArrayList<>();
        int countOfHeroes = heroes.size();
        for (int i = 0; i < countOfHeroes / 2; i++) {
            pairs.add(new PairToFight<>(
                    heroes.get(i),
                    heroes.get(countOfHeroes - i - 1)
            ));
        }
        return pairs;
    }

    public static void printResultOfFight(PairToFight<Superhero> pairToFight) {
        String title = String.format("Fight %s vs %s:", pairToFight.getLeft(), pairToFight.getRight());

        Optional<Superhero> winnerOpt = pairToFight.getWinner();
        if (winnerOpt.isEmpty()) {
            System.out.printf("%s We have not a winner!", title);
        } else {
            System.out.printf("%s Winner is %s%n", title, winnerOpt.get().name().toUpperCase());
        }
    }

    public static List<Superhero> getWinnersFromFutures(List<Future<PairToFight<Superhero>>> futures) {
        List<Superhero> winners = new ArrayList<>();
        try {
            for (Future<PairToFight<Superhero>> future : futures) {
                PairToFight<Superhero> pair = future.get();
                if (pair.getWinner().isPresent()) {
                    winners.add(pair.getWinner().get());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("Main was interrupted: " + e);
        }
        return winners;
    }

}
