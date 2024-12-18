package school.faang.task_49557;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Main {
    private static final int TASK_COUNT = 10;
    private static final int THREAD_COUNT = 5;
    private static final int VLADS_COUNT = 10;
    private static final int TIMEOUT_MINUTES = 5;

    public static void main(String[] args) {
        VladController controller = new VladController();

        for (int i = 0; i < VLADS_COUNT; i++) {
            controller.addVlad();
        }

        List<Consumer<VladController>> methods = new ArrayList<>();
        methods.add(VladController::feedAll);
        methods.add(VladController::playAll);
        methods.add(VladController::sleepAll);
        methods.add(VladController::cleanAll);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        Random random = new Random();

        for (int i = 0; i < TASK_COUNT; i++) {
            executorService.submit(() -> methods.get(random.nextInt(0, methods.size())).accept(controller));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Задачи завершены. Влад свободен");
            } else {
                System.out.println("Времени не хватило.");
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка выполнения задач: " + e);
        }
    }
}
