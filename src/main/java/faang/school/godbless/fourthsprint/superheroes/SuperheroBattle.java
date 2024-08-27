package faang.school.godbless.fourthsprint.superheroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroPairs) {
        List<Future<Superhero>> futures = new ArrayList<>();

        for (Pair<Superhero, Superhero> pair : superheroPairs) {
            futures.add(executor.submit(() -> {
                Superhero superhero1 = pair.getFirst();
                Superhero superhero2 = pair.getSecond();

                if (superhero1.getPower() > superhero2.getPower()) {
                    return superhero1;
                } else {
                    return superhero2;
                }
            }));
        }
        return futures;
    }

    public Superhero findStrongestSuperhero(List<Superhero> superheroes) throws InterruptedException, ExecutionException {
        List<Superhero> copy = new ArrayList<>(superheroes);

        List<Superhero> remainingHeroes = new ArrayList<>();

        if (copy.size() == 1) {
            System.out.println(copy.get(0));
            return copy.get(0);
        }
        if (copy.size() % 2 != 0) {
            Collections.shuffle(copy);
            Superhero superhero1 = copy.remove(0);
            remainingHeroes.add(superhero1);
        }

        List<Pair<Superhero, Superhero>> superheroPairs = generatePairs(superheroes);
        superheroPairs.stream().forEach(System.out::println);

        List<Future<Superhero>> winnersFutures = runCompetitions(superheroPairs);
        List<Superhero> winners = new ArrayList<>();
        for (Future<Superhero> future : winnersFutures) {
            winners.add(future.get());

        }
        remainingHeroes.addAll(winners);
        System.out.println("remaining heroes: ");
        remainingHeroes.stream().forEach(System.out::println);
        return findStrongestSuperhero(winners);
    }


    private List<Pair<Superhero, Superhero>> generatePairs(List<Superhero> superheroes) {
        List<Pair<Superhero, Superhero>> newPairs = new ArrayList<>();
        Collections.shuffle(superheroes);

        for (int i = 0; i < superheroes.size() - 1; i += 2) {
            newPairs.add(new Pair<>(superheroes.get(i), superheroes.get(i + 1)));
        }
        return newPairs;
    }
}