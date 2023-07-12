package faang.school.godbless.kxnvg.superheroes;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairList) {
        List<Future<Superhero>> resultList = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(pairList.size());

        for (Pair pair : pairList) {
            Future<Superhero> future = service.submit(() -> pair.fight());
            resultList.add(future);
        }
        service.shutdown();
        return resultList;
    }

    @SneakyThrows
    public Superhero runCompetitionsFinal(List<Pair<Superhero, Superhero>> pairList) {
        List<Future<Superhero>> resultList = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(pairList.size());

        for (Pair pair : pairList) {
            Future<Superhero> future = service.submit(() -> pair.fight());
            resultList.add(future);
        }
        service.shutdown();

        if (resultList.size() == 1) {
            return resultList.get(0).get();
        }

        int left = 0;
        int right = resultList.size() - 1;
        List<Pair<Superhero, Superhero>> newPairList = new ArrayList<>();

        while (left < right) {
            newPairList.add(new Pair<>(resultList.get(left).get(), resultList.get(right).get()));
            left++;
            right--;
        }
        runCompetitionsFinal(newPairList);

        return null;
    }
}
