package school.faang.bjs249150;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Music {
    private static final Random random = new Random();
    private static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) {
        List<Consumer<Player>> methodCalls = new ArrayList<>();
        methodCalls.add(Player::play);
        methodCalls.add(Player::pause);
        methodCalls.add(Player::skip);
        methodCalls.add(Player::previous);

        Player player = new Player();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);
        for (int i = 0; i < 5; i++) {
            executorService
                    .submit(() -> methodCalls.get(random.nextInt(0, methodCalls.size()))
                            .accept(player));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("The thread was interrupted while waiting for ExecutorService to terminate: "
                    + e.getMessage());
        }

        System.out.println("The music track is finished");

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("The tasks were not completed in 5 seconds, "
                        + "we forcefully stop the ThreadPool");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("The main thread was interrupted while waiting, we forcefully stop the ThreadPool"
                    + e.getMessage());
            executorService.shutdownNow();
        }
    }
}