package faang.school.godbless.superheroes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();
        List<Pair<Superhero, Superhero>> superheroPairs = getHeroPairs();

        BiFunction<Superhero, Superhero, Superhero> competitionLogic = (superhero1, superhero2) -> {
            if (getCharacteristics(superhero1) > getCharacteristics(superhero2)) {
                return superhero1;
            } else {
                return superhero2;
            }
        };
        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs, competitionLogic);

        printWinners(winnersFutures);
    }

    private static List<Pair<Superhero, Superhero>> getHeroPairs() {
        Superhero ironMan = new Superhero("Iron Man", 9, 6);
        Superhero captainAmerica = new Superhero("Captain America", 8, 8);
        Superhero thor = new Superhero("Thor", 10, 7);
        Superhero hulk = new Superhero("Hulk", 10, 4);

        return Arrays.asList(
                new Pair<>(ironMan, captainAmerica),
                new Pair<>(thor, hulk),
                new Pair<>(thor, hulk));
    }

    private static void printWinners(List<Future<Superhero>> winners) {
        for (int i = 0; i < winners.size(); i++) {
            Superhero winner = getFromFuture(winners.get(i));
            System.out.println(String.format("Winner of competitions %d: %s", i + 1, winner));
        }
    }

    private static <T> T getFromFuture(Future<T> future) {
        try {
            return future.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted");
        } catch (ExecutionException e) {
            throw new RuntimeException("Thread was interrupted");
        } catch (TimeoutException e) {
            throw new RuntimeException("The waiting time has been exceeded");
        }
    }

    private static int getCharacteristics(Superhero superhero) {
        return superhero.getAgility() + superhero.getStrength();
    }
}
