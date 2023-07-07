package faang.school.godbless.sprint5.superHeroBattles.classes;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SuperheroBattle {

    @SneakyThrows
    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> list) {
        ExecutorService threadPool = Executors.newFixedThreadPool(list.size());
        List<Future<Superhero>> resultList = new ArrayList<>();
        for (Pair<Superhero, Superhero> pair : list) {
            resultList.add(threadPool.submit(() ->
                    Superhero.getStrongestHero(pair.getFirst(), pair.getSecond())));
        }
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
        return resultList;
    }
}
