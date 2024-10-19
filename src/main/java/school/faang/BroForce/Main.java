package school.faang.BroForce;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10, 10);

        Random random = new Random();

        ExecutorService service = Executors.newFixedThreadPool(5);

        int rounds = 50;

        for (int i = 0; i < rounds; i++) {
            service.execute(() -> {
                game.update(random.nextBoolean(), random.nextBoolean());
            });
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong", e);
        }
    }
}
