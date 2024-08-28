package faang.school.godbless.superBattle;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    private final long TIMER = 1000L;

    public Future<Superhero> runCompetitions(@NonNull List<MyPair<Superhero, Superhero>> heroPairs) {
        ExecutorService cacheExecutor = Executors.newCachedThreadPool();

        List<MyPair<Superhero, Superhero>> tournamentPairs = heroPairs;
        List<Future<Superhero>> futuresResult;

        do {
            futuresResult = tournamentPairs.stream()
                    .map(pair -> cacheExecutor.submit(() -> {
                        try {
                            Thread.sleep(TIMER);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        return getWinnerOfPairSuperheros(pair);
                    }))
                    .toList();

            if (futuresResult.size() >= 2) {
                tournamentPairs = createSuperheroPairs(futuresResult);
            }
        } while (futuresResult.size() > 1);

        cacheExecutor.shutdown();

        return futuresResult.get(0);
    }

    private Superhero getWinnerOfPairSuperheros(@NonNull MyPair<Superhero, Superhero> superheroPair) {
        if (superheroPair.second() == null) {
            return superheroPair.first();
        }

        return (superheroPair.first().strength() >= superheroPair.second().strength())
                ? superheroPair.first()
                : superheroPair.second();
    }

    public List<MyPair<Superhero, Superhero>> createSuperheroPairs(List<Future<Superhero>> futuresResult) {
        List<MyPair<Superhero, Superhero>> pairs = new ArrayList<>();

        for (int i = 0; i < futuresResult.size(); i += 2) {
            Superhero first = null;
            Superhero second = null;

            try {
                first = futuresResult.get(i).get();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (i + 1 < futuresResult.size()) {
                try {
                    second = futuresResult.get(i + 1).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            assert first != null;
            pairs.add(new MyPair<>(first, second));
        }

        return pairs;
    }
}
