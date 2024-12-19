package school.faang.bjs249585;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Main {
    private static final Random random = new Random();
    private static final int MIN_THREADS_AMOUNT = 1;
    private static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) {
        Controller controller = new Controller();
        for (int i = 0; i < 5; i++) {
            controller.addTamagochi();
        }

        List<Consumer<Controller>> methodCalls = new ArrayList<>();
        methodCalls.add(Controller::feedAll);
        methodCalls.add(Controller::playAll);
        methodCalls.add(Controller::sleepAll);
        methodCalls.add(Controller::cleanAll);

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        for (int i = MIN_THREADS_AMOUNT; i <= THREADS_AMOUNT; i++) {
            executorService
                    .submit(() -> methodCalls.get(random.nextInt(0, methodCalls.size())).accept(controller));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("The thread was interrupted while waiting for ExecutorService to terminate: "
                    + e.getMessage());
        }

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