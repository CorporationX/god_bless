package school.faang.hero_buttle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void startTournament(List<Superhero> heroesList) {
        int round = 1;
        while (heroesList.size() > 1){
            List<Future<Superhero>> futures = runCompetitions(heroesList);
            createListForNextRound(heroesList, futures);
            statistic(heroesList, round++);
        }
        executorService.shutdown();
    }

    private void createListForNextRound(List<Superhero> heroesList, List<Future<Superhero>> futures) {
        heroesList.clear();
        try {
            for (Future<Superhero> future : futures) {
                heroesList.add(future.get());
            }
        } catch (InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }
    }

    private void statistic(List<Superhero> heroesList, int i) {
        System.out.printf("После %d раунда остались герои:\n", i);
        heroesList.forEach(System.out::println);
        System.out.println();
    }

    private List<Future<Superhero>> runCompetitions(List<Superhero> heroesList){
        List<Pair<Superhero, Superhero>> pairList = createRandomPairList(heroesList);
        return roundOfTournament(pairList);
    }

    private List<Pair<Superhero, Superhero>> createRandomPairList(List<Superhero> heroesList) {
        Collections.shuffle(heroesList);
        List<Pair<Superhero, Superhero>> result = new ArrayList<>();

        for (int i = 0; i < heroesList.size() - 1; i += 2) {
            result.add(new Pair<>(heroesList.get(i), heroesList.get(i+1)));
        }

        if (heroesList.size() % 2 != 0){
            Superhero superhero = heroesList.get(heroesList.size()-1);
            result.add(new Pair<>(superhero, superhero));
        }
        return result;
    }

    private List<Future<Superhero>> roundOfTournament(List<Pair<Superhero, Superhero>> pairList) {
        return pairList.stream()
                .map(pair -> battle(pair))
                .toList();
    }

    private Future<Superhero> battle(Pair<Superhero, Superhero> pairHero){
        Superhero superhero1 = pairHero.t1();
        Superhero superhero2 = pairHero.t2();

        return executorService.submit(() -> superhero1.fight(superhero2));
    }
}
