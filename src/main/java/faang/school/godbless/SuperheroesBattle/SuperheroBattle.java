package faang.school.godbless.SuperheroesBattle;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<AbstractMap.SimpleEntry<Superhero, Superhero>> pairList) {
        List<Future<Superhero>> result = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(pairList.size());

        pairList.forEach(pair -> {
            result.add(executorService.submit(() -> {
                if (pair.getKey().getStrength() + pair.getKey().getAgility() > pair.getValue().getAgility() + pair.getValue().getStrength()) {
                    return pair.getKey();
                } else {
                    return pair.getValue();
                }
            }));
        });

        return result;
    }
}
