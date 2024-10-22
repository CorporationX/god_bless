package school.faang.fourthStream.BJS2_38397;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void startTournament(List<Superhero> heroesList) {
        int round = 1;
        while (heroesList.size() > 1) {
            List<Future<Superhero>> futures = runCompetitions(heroesList);
            createListForNextRound(heroesList, futures);
            statistic(heroesList, round++);
        }

        executor.shutdown();
    }

    private void createListForNextRound(List<Superhero> heroesList, List<Future<Superhero>> futures) {
        heroesList.clear();
        try {
            for (Future<Superhero> future : futures) {
                heroesList.add(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private void statistic(List<Superhero> heroesList, int i) {
        System.out.printf("После %d раунда остались герои: %n", i);
        heroesList.forEach(System.out::println);
        System.out.println();
    }

    private List<Future<Superhero>> runCompetitions(List<Superhero> heroesList) {
        List<Pair<Superhero, Superhero>> pairs = createRandomPairs(heroesList);

        return roundOfTournament(pairs);
    }

    private List<Pair<Superhero, Superhero>> createRandomPairs(List<Superhero> heroesList) {
        Collections.shuffle(heroesList);
        List<Pair<Superhero, Superhero>> result = new ArrayList<>();

        for (int i = 0; i < heroesList.size() - 1; i += 2) {
            result.add(new Pair<>(heroesList.get(i), heroesList.get(i + 1)));
        }

        if ((heroesList.size() & 1) != 0) {
            Superhero superhero = heroesList.get(heroesList.size() - 1);
            result.add(new Pair<>(superhero, superhero));
        }

        return result;
    }

    private List<Future<Superhero>> roundOfTournament(List<Pair<Superhero, Superhero>> pairs) {
        return pairs.stream()
                .map(this::battle)
                .toList();
    }

    private Future<Superhero> battle(Pair<Superhero, Superhero> pairHero) {
        Superhero superhero1 = pairHero.t1();
        Superhero superhero2 = pairHero.t2();

        return executor.submit(() -> superhero1.fight(superhero2));
    }
}
