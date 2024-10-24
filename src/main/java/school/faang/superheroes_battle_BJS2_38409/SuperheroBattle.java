package school.faang.superheroes_battle_BJS2_38409;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
public class SuperheroBattle {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Future<Superhero> runCompetitions(List<Pair> competitions) {
        List<Future<Superhero>> futures = new ArrayList<>();

        competitions.forEach(pair -> futures.add(executor.submit(() -> {
            int totalPower1 = (pair.getFistSuperhero().getAgility() + pair.getFistSuperhero().getStrength());
            int totalPower2 = (pair.getSecondSuperhero().getAgility() + pair.getSecondSuperhero().getStrength());
            return totalPower1 >= totalPower2 ? pair.getFistSuperhero() : pair.getSecondSuperhero();
        })));

        if (isSizeOne(futures.size())) {
            final int FIRST_INDEX = 0;
            return futures.get(FIRST_INDEX);
        }
        competitions.clear();
        List<Pair> nextRoundPairs = new ArrayList<>();

        if (isEvenNumber(futures.size())) {
            repeatBattle(nextRoundPairs, futures, futures.size());
        } else {
            repeatBattle(nextRoundPairs, futures, deleteLastOddIndex(futures.size()));
        }

        return runCompetitions(nextRoundPairs);
    }

    private void repeatBattle(List<Pair> superheroPairs,
                              List<Future<Superhero>> winnersFutures, int listSize) {
        final int ONE_INDEX = 1;
        final int DOUBLE_INCREMENT = 2;
        for (int i = 0; i < listSize; i += DOUBLE_INCREMENT) {
            try {
                superheroPairs.add(new Pair(winnersFutures.get(i).get(),
                        winnersFutures.get(i + ONE_INDEX).get()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    private boolean isSizeOne(int number) {
        return number == 1;
    }

    private int deleteLastOddIndex(int number) {
        return number - 1;
    }
}