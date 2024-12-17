package school.faang.task_49557;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        for (int i = 0; i < 5; i++) {
            controller.addVlad();
        }

        List<Consumer<VladController>> methods = new ArrayList<>();
        methods.add(VladController::feedAll);
        methods.add(VladController::playAll);
        methods.add(VladController::sleepAll);
        methods.add(VladController::cleanAll);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> methods.get(random.nextInt(0, methods.size())).accept(controller));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи завершены. Влад свободен");
            } else {
                System.out.println("Времени не хватило.");
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка выполнения задач: " + e);
        }
    }
}
