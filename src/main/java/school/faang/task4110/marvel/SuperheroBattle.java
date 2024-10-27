package school.faang.task4110.marvel;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SuperheroBattle {
    private ExecutorService service = Executors.newFixedThreadPool(10);

    public List<Future<Superhero>> runCompetitions(List<MyPair<Superhero>> supers) {
        return supers.stream()
                .map(pair -> service.submit(() -> pair.getFirst().fight(pair.getSecond())))
                .collect(Collectors.toList());
    }

    public void shutdown() {
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
