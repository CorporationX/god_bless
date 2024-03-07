package faang.school.godbless.superheroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SuperheroBattle {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairsOfHeroes, BiFunction<Superhero, Superhero, Superhero> competitionLogic) {
        List<Future<Superhero>> winners =  pairsOfHeroes.stream()
                .map(heroPair -> CompletableFuture.supplyAsync(() -> competitionLogic.apply(heroPair.getFirst(), heroPair.getSecond()), executorService))
                .collect(Collectors.toList());
        if (pairsOfHeroes.size() == 1) {
            return winners;
        }
        return runCompetitions(getMixedWinners(winners), competitionLogic);
    }

    public void shutdownAndAwaitExecution(int minutes) {
        executorService.shutdown();
        awaitTermination(minutes);
    }

    private List<Pair<Superhero, Superhero>> getMixedWinners(List<Future<Superhero>> winners) {
        List<Pair<Superhero, Superhero>> newPairs = new ArrayList<>();
        for (int i = 0; i < winners.size(); i += 2) {
            Superhero firstWinner = getFromFuture(winners.get(i));
            if (i + 1 < winners.size()) {
                Superhero secondWinner = getFromFuture(winners.get(i + 1));
                newPairs.add(new Pair<>(firstWinner, secondWinner));
            } else {
                newPairs.add(new Pair<>(firstWinner, new Superhero("null", 0, 0)));
            }
        }
        return newPairs;
    }

    private void awaitTermination(int minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted");
        }
    }

    private <T> T getFromFuture(Future<T> future) {
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
}
