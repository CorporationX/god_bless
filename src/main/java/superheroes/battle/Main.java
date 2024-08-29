package superheroes.battle;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_HEROES = 64;
    private static final int MAX_POINTS = 10;

    public static void main(String[] args) {
        var heroes = initHeroes();
        var winner = startCompetition(heroes);

        log.info("The winner is " + winner.getName());
    }

    private static Superhero startCompetition(@NonNull List<Superhero> superheroes) {
        if (!isNumberPowerOfTwo(superheroes.size())) {
            throw new IllegalArgumentException("Illegal numbers of competition (should be power of two");
        }
        log.info("Start competition!");
        SuperheroBattle superheroBattle = new SuperheroBattle();
        List<Superhero> currentRoundCompetitors = new ArrayList<>(superheroes);
        while (currentRoundCompetitors.size() > 1) {
            log.info("Competitors of this round:");
            printCompetitors(currentRoundCompetitors);
            var futures = superheroBattle.runCompetition(initBattlePairs(currentRoundCompetitors));
            currentRoundCompetitors = futures.stream()
                    .map(f -> {
                                try {
                                    return f.get(10, TimeUnit.SECONDS);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                    throw new RuntimeException(e);
                                } catch (ExecutionException | TimeoutException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    ).toList();
        }
        superheroBattle.shutdown();
        log.info("End competition");
        return currentRoundCompetitors.get(0);
    }

    private static List<Pair<Superhero, Superhero>> initBattlePairs(@NonNull List<Superhero> superheroes) {
        int size = superheroes.size() / 2;
        List<Pair<Superhero, Superhero>> battlePairs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            battlePairs.add(new Pair<>(superheroes.get(i * 2), superheroes.get(i * 2 + 1)));
        }
        return battlePairs;
    }

    private static boolean isNumberPowerOfTwo(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }

    private static void printCompetitors(@NonNull List<Superhero> superheroes) {
        superheroes.forEach(h -> log.info(h.getName()));
    }

    private static List<Superhero> initHeroes() {
        Random rand = new Random();
        return IntStream.rangeClosed(1, NUMBER_OF_HEROES)
                .mapToObj(i -> new Superhero(
                        "Hero_" + i, rand.nextInt(MAX_POINTS) + 1, rand.nextInt(MAX_POINTS) + 1))
                .toList();
    }
}
