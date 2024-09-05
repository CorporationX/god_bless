package faang.school.godbless.multithreading.parallelism.feedpeter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(characterName, new Random().nextInt(10) + 1));
        }

        executorService.shutdown();

        boolean done;

        try {
            done = executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!done) {
            System.err.println("Превышен тайм-аут ожидания завершения потоков");
            List<Runnable> rejected = executorService.shutdownNow();
            System.out.println("Отклоненные задачи: " + rejected.size());
        }

        if (executorService.isShutdown()) {
            System.out.println("ExecutorService выключен.");
        }

        if (executorService.isTerminated()) {
            System.out.println("Все задачи выполнены.");
        }
    }
}
