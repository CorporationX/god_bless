package school.faang.bjs250591;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {

    public List<Future<Superhero>> runCompetitions(List<Pair<Superhero, Superhero>> pairList) {
        ExecutorService executor = Executors.newFixedThreadPool(pairList.size());
        List<Future<Superhero>> futures = new ArrayList<>();
        try {
            for (Pair<Superhero, Superhero> pair : pairList) {
                Future<Superhero> future = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(5_000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Superhero first = pair.first;
                    Superhero second = pair.second;
                    return pair.first.getTotalPower() > pair.second.getTotalPower() ? first
                            : pair.first.getTotalPower() < pair.second.getTotalPower() ? second : null;
                }, executor);
                futures.add(future);
            }
        } finally {
            executor.shutdown();
        }
        return futures;
    }

}
