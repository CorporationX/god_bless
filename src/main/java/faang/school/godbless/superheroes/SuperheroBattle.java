package faang.school.godbless.superheroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair> listOfPairs) {
        List<Future<Superhero>> futuresList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(listOfPairs.size());

        for (Pair pair : listOfPairs) {
            Future<Superhero> submit = executorService.submit(pair::determineWinner);
            futuresList.add(submit);
        }

        executorService.shutdown();

        return futuresList;
    }
}
