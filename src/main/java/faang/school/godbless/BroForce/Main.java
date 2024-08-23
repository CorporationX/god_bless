package faang.school.godbless.BroForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(List.of(
                new Player("1", 4),
                new Player("2", 5),
                new Player("3", 2)
        ));

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            service.execute(game::update);
        }

        stop(service);
    }

    private static void stop(ExecutorService service) {
        service.shutdown();
        try {
            if (service.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
