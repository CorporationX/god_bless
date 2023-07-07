package faang.school.godbless.asyncAndFuture.superheroesBattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    private final Random random = new Random();

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> superheroPairList) {
        ExecutorService executorService = Executors.newFixedThreadPool(superheroPairList.size());
        List<Future<Superhero>> superheroWinnerFutureList = new ArrayList<>();

        superheroPairList.forEach((pair) ->
            superheroWinnerFutureList.add(executorService.submit(() -> getWinner(pair)))
        );

        executorService.shutdown();

        return superheroWinnerFutureList;
    }

    private Superhero getWinner(Pair<Superhero, Superhero> superheroPair) {
        int sumOfAbilities1 = superheroPair.getFirst().getStrength() + superheroPair.getFirst().getAgility();
        int sumOfAbilities2 = superheroPair.getSecond().getStrength() + superheroPair.getSecond().getAgility();
        if (sumOfAbilities1 > sumOfAbilities2)
            return superheroPair.getFirst();
        else if (sumOfAbilities2 > sumOfAbilities1)
            return superheroPair.getSecond();
        else {
            if (random.nextBoolean())
                return superheroPair.getFirst();
            else
                return superheroPair.getSecond();
        }
    }
}
